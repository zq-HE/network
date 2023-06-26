package com.nju.edu.network.entity.vo.packageFormat;

import com.nju.edu.network.entity.vo.packageFormat.packagehead.PackageHead;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NetworkPackage {
    PackageHead head;
    TransportPackage data;
}
