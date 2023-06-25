package com.nju.edu.network.entity.packageFormat.packagehead;

import com.nju.edu.network.entity.packageFormat.PackageHead;

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
