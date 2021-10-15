package ru.soniir.crccalc;

/**
 * Created by anthony on 11.05.2017.
 */
public class CrcCalculator {

    private AlgoParams parameters;
    
    private byte hashSize;
    private long mask = 0xFFFFFFFFFFFFFFFFL;
    private long[] table = new long[256];

    

    public CrcCalculator(CrcAlgorithm algorithm){
        this(algorithm.getParams());
    }
    
    public CrcCalculator(AlgoParams parameters)
    {
        this.parameters = parameters;

        this.hashSize = (byte) parameters.getHashSize();
        if (this.hashSize < 64)
        {
            mask = (1L << this.hashSize) - 1;
        }

        createTable();
    }

    public long calc(byte[] data){
        return calc(data, 0, data.length);
    }
    
    public long calc(byte[] data, int offset, int length)
    {
        long init = parameters.isRefOut() ? 
                CrcHelper.reverseBits(parameters.getInit(), hashSize) : 
                parameters.getInit();
        long hash = computeCrc(init, data, offset, length);
        return (hash ^ parameters.getXorOut()) & mask;
    }

    private long computeCrc(long init, byte[] data, int offset, int length)
    {
        long crc = init;

        if (parameters.isRefOut())
        {
            for (int i = offset; i < offset + length; i++)
            {
                crc = (table[(int)((crc ^ data[i]) & 0xFF)] ^ (crc >>> 8));
                crc &= mask;
            }
        }
        else
        {
            int toRight = (hashSize - 8);
            toRight = toRight < 0 ? 0 : toRight;
            for (int i = offset; i < offset + length; i++)
            {
                crc = (table[(int)(((crc >> toRight) ^ data[i]) & 0xFF)] ^ (crc << 8));
                crc &= mask;
            }
        }

        return crc;
    }

    private void createTable()
    {
        for (int i = 0; i < table.length; i++)
            table[i] = createTableEntry(i);
    }

    private long createTableEntry(int index)
    {
        long r = (long)index;

        if (parameters.isRefIn())
            r = CrcHelper.reverseBits(r, hashSize);
        else if (hashSize > 8)
            r <<= (hashSize - 8);

        long lastBit = (1L << (hashSize - 1));

        for (int i = 0; i < 8; i++)
        {
            if ((r & lastBit) != 0)
                r = ((r << 1) ^ parameters.getPoly());
            else
                r <<= 1;
        }

        if (parameters.isRefOut())
            r = CrcHelper.reverseBits(r, hashSize);

        return r & mask;
    }

    public AlgoParams getParameters() {
        return parameters;
    }
}
