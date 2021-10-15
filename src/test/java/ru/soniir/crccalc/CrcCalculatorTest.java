/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.soniir.crccalc;

import java.util.Arrays;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author minaev
 */
public class CrcCalculatorTest {
    
    public CrcCalculatorTest() {
    }

    /**
     * Test of calc method, of class CrcCalculator.
     */
    @Test
    public void testCalc_byteArr() {
        System.out.println("calc");
        byte[] data = AlgoParams.testBytes;
        
        long cntFailAlgs = Arrays.stream(CrcAlgorithm.values())
            .map(CrcCalculator::new)
            .filter(c->c.calc(data)!=c.getParameters().getCheck())
            .peek(c->System.out.println("bad algorithm: " + c.getParameters().getName()))
            .count();
        
        assertEquals(cntFailAlgs, 0);
    }

    /**
     * Test of calc method, of class CrcCalculator.
     */
    @Test
    public void testCalc_3args() {
        System.out.println("calc");
        byte[] data = new byte[AlgoParams.testBytes.length*2];
        Random r = new Random();
        
        for(CrcAlgorithm alg : CrcAlgorithm.values()){
            int offset = r.nextInt(AlgoParams.testBytes.length);
            System.arraycopy(AlgoParams.testBytes, 0, 
                    data, offset, AlgoParams.testBytes.length);
            CrcCalculator calc = new CrcCalculator(alg);
            assertEquals(calc.calc(data, offset, AlgoParams.testBytes.length), 
                    alg.getParams().getCheck());
        }
    }

    /**
     * Test of getParameters method, of class CrcCalculator.
     */
    @Test
    public void testGetParameters() {
        System.out.println("getParameters");
        CrcCalculator instance = new CrcCalculator(CrcAlgorithm.Crc16Dds110);
        AlgoParams expResult = CrcAlgorithm.Crc16Dds110.getParams();
        AlgoParams result = instance.getParameters();
        assertEquals(expResult, result);
    }
    
}
