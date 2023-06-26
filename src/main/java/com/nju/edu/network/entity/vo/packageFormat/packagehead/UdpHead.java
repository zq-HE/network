package com.nju.edu.network.entity.vo.packageFormat.packagehead;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UdpHead extends PackageHead {
    String sourcePort;
    String destinationPort;
    String packageLength;
    String checksum;
}
