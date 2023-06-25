package com.nju.edu.network.entity.packageFormat.packagehead;

import com.nju.edu.network.entity.packageFormat.PackageHead;

public class IcmpHead extends PackageHead {
    String type;
    String code;
    String checksum;
    String identifier;
    String sequenceNumber;
    String timestamp;
}
