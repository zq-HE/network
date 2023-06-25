package com.nju.edu.network.entity.packageFormat.packagehead;

import com.nju.edu.network.entity.packageFormat.PackageHead;

public class ArpHead extends PackageHead {
    String hardwareType;
    String protocolType;
    String hardwareAddressLength;
    String protocolAddressLength;
    String operationCode;
    String sourceHardwareAddress;
    String sourceProtocolAddress;
    String destinationHardwareAddress;
    String destinationProtocolAddress;
}
