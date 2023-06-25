package com.nju.edu.network.entity.packageFormat.packagehead;

import com.nju.edu.network.entity.packageFormat.PackageHead;

public class UdpHead extends PackageHead {
    String sourcePort;
    String destinationPort;
    String packageLength;
    String checksum;
}
