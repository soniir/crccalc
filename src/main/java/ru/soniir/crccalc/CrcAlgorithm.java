package ru.soniir.crccalc;

/**
 * Crc algorithm types enum
 * @author minaev
 */
public enum CrcAlgorithm {
    Crc8,
    Crc8Cdma2000,
    Crc8Darc,
    Crc8DvbS2,
    Crc8Ebu,
    Crc8ICode,
    Crc8Itu,
    Crc8Maxim,
    Crc8Rohc,
    Crc8Wcdma,
    Crc16CcittFalse,
    Crc16Arc,
    Crc16AugCcitt,
    Crc16Buypass,
    Crc16Cdma2000,
    Crc16Dds110,
    Crc16DectR,
    Crc16DectX,
    Crc16Dnp,
    Crc16En13757,
    Crc16Genibus,
    Crc16Maxim,
    Crc16Mcrf4Xx,
    Crc16Riello,
    Crc16T10Dif,
    Crc16Teledisk,
    Crc16Tms37157,
    Crc16Usb,
    CrcA,
    Crc16Kermit,
    Crc16Modbus,
    Crc16X25,
    Crc16Xmodem,
    Crc64,
    Crc64We,
    Crc64Xz,
    ;
    
    private static final AlgoParams params[] = new AlgoParams[]{
        new AlgoParams("CRC-8", 8, 0x7, 0x0, false, false, 0x0, 0xF4),
        new AlgoParams("CRC-8/CDMA2000", 8, 0x9B, 0xFF, false, false, 0x0, 0xDA),
        new AlgoParams("CRC-8/DARC", 8, 0x39, 0x0, true, true, 0x0, 0x15),
        new AlgoParams("CRC-8/DVB-S2", 8, 0xD5, 0x0, false, false, 0x0, 0xBC),
        new AlgoParams("CRC-8/EBU", 8, 0x1D, 0xFF, true, true, 0x0, 0x97),
        new AlgoParams("CRC-8/I-CODE", 8, 0x1D, 0xFD, false, false, 0x0, 0x7E),
        new AlgoParams("CRC-8/ITU", 8, 0x7, 0x0, false, false, 0x55, 0xA1),
        new AlgoParams("CRC-8/MAXIM", 8, 0x31, 0x0, true, true, 0x0, 0xA1),
        new AlgoParams("CRC-8/ROHC", 8, 0x7, 0xFF, true, true, 0x0, 0xD0),
        new AlgoParams("CRC-8/WCDMA", 8, 0x9B, 0x0, true, true, 0x0, 0x25),
        new AlgoParams("CRC-16/CCITT-FALSE", 16, 0x1021, 0xFFFF, false, false, 0x0, 0x29B1),
        new AlgoParams("CRC-16/ARC", 16, 0x8005, 0x0, true, true, 0x0, 0xBB3D),
        new AlgoParams("CRC-16/AUG-CCITT", 16, 0x1021, 0x1D0F, false, false, 0x0, 0xE5CC),
        new AlgoParams("CRC-16/BUYPASS", 16, 0x8005, 0x0, false, false, 0x0, 0xFEE8),
        new AlgoParams("CRC-16/CDMA2000", 16, 0xC867, 0xFFFF, false, false, 0x0, 0x4C06),
        new AlgoParams("CRC-16/DDS-110", 16, 0x8005, 0x800D, false, false, 0x0, 0x9ECF),
        new AlgoParams("CRC-16/DECT-R", 16, 0x589, 0x0, false, false, 0x1, 0x7E),
        new AlgoParams("CRC-16/DECT-X", 16, 0x589, 0x0, false, false, 0x0, 0x7F),
        new AlgoParams("CRC-16/DNP", 16, 0x3D65, 0x0, true, true, 0xFFFF, 0xEA82),
        new AlgoParams("CRC-16/EN-13757", 16, 0x3D65, 0x0, false, false, 0xFFFF, 0xC2B7),
        new AlgoParams("CRC-16/GENIBUS", 16, 0x1021, 0xFFFF, false, false, 0xFFFF, 0xD64E),
        new AlgoParams("CRC-16/MAXIM", 16, 0x8005, 0x0, true, true, 0xFFFF, 0x44C2),
        new AlgoParams("CRC-16/MCRF4XX", 16, 0x1021, 0xFFFF, true, true, 0x0, 0x6F91),
        new AlgoParams("CRC-16/RIELLO", 16, 0x1021, 0xB2AA, true, true, 0x0, 0x63D0),
        new AlgoParams("CRC-16/T10-DIF", 16, 0x8BB7, 0x0, false, false, 0x0, 0xD0DB),
        new AlgoParams("CRC-16/TELEDISK", 16, 0xA097, 0x0, false, false, 0x0, 0xFB3),
        new AlgoParams("CRC-16/TMS37157", 16, 0x1021, 0x89EC, true, true, 0x0, 0x26B1),
        new AlgoParams("CRC-16/USB", 16, 0x8005, 0xFFFF, true, true, 0xFFFF, 0xB4C8),
        new AlgoParams("CRC-A", 16, 0x1021, 0xc6c6, true, true, 0x0, 0xBF05),
        new AlgoParams("CRC-16/KERMIT", 16, 0x1021, 0x0, true, true, 0x0, 0x2189),
        new AlgoParams("CRC-16/MODBUS", 16, 0x8005, 0xFFFF, true, true, 0x0, 0x4B37),
        new AlgoParams("CRC-16/X-25", 16, 0x1021, 0xFFFF, true, true, 0xFFFF, 0x906E),
        new AlgoParams("CRC-16/XMODEM", 16, 0x1021, 0x0, false, false, 0x0, 0x31C3),
        new AlgoParams("CRC-64",64, 0x42F0E1EBA9EA3693L, 0x00000000L, false, false, 0x00000000L, 0x6C40DF5F0B497347L),
        new AlgoParams("CRC-64/WE", 64, 0x42F0E1EBA9EA3693L, 0xFFFFFFFFFFFFFFFFL, false, false, 0xFFFFFFFFFFFFFFFFL,0x62EC59E3F1A4F00AL),
        new AlgoParams("CRC-64/XZ", 64, 0x42F0E1EBA9EA3693L, 0xFFFFFFFFFFFFFFFFL, true, true, 0xFFFFFFFFFFFFFFFFL,0x995DC9BBDF1939FAL),
    };
    
    public AlgoParams getParams(){
        return params[ordinal()];
    }

}
