package com.nju.edu.network.entity.vo.packageFormat.packagehead;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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
