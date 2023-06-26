package com.nju.edu.network.entity.vo.packageFormat.packagehead;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IpHead extends PackageHead {
    String version;
    String headLength;
    String typeOfService;
    String packageLength;
    String identification;
    String Flags;
    String fragmentOffset;
    String TTL;
    String protocol;
    String checksum;
    String sourceIpAddress;
    String destinationIpAddress;
    String options;
    String padding;
}
