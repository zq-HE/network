package com.nju.edu.network.entity.vo.packageFormat.packagehead;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IcmpHead extends PackageHead {
    String type;
    String code;
    String checksum;
    String identifier;
    String sequenceNumber;
    String timestamp;
}
