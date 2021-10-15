# crccalc
Java CRC calculator with many popularity algorithm include CRC8/16/32/64

Based on https://github.com/meetanthony/crcjava
Copyright (c) 2017 Anton Isakov http://crccalc.com

## Usage

For use predefined CRC algorithm:

```java
CrcCalculator calculator = new CrcCalculator(CrcAlgorithm.Crc16Usb);

long checksum = calculator.calc(new byte[]{1, 2, 3, 4, 5});

System.out.println(String.format("CRC16/USB: 0x%04x", checksum));
```

Custom CRC algorithm:

```java
AlgoParams customCrcAlgoParams = new AlgoParams("CRC-16/MY_ALG", 16, 
        0x3DC1, 0xAA55, true, true, 0xFFFF, 0xA768);

CrcCalculator calculator = new CrcCalculator(customCrcAlgoParams);

long checksum = calculator.calc(new byte[]{1, 2, 3, 4, 5});

System.out.println(String.format("CRC16/MY_ALG: 0x%04x", checksum));
```

## Download

### Gradle
```
implementation 'ru.soniir:crccalc:1.0'
```
### Maven
```
<dependency>
  <groupId>ru.soniir</groupId>
  <artifactId>crccalc</artifactId>
  <version>1.0</version>
</dependency>
```
