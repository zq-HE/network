package com.nju.edu.network.entity.vo;

import com.nju.edu.network.entity.packageFormat.Layer;
import com.nju.edu.network.entity.packageFormat.PackageHead;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NetPackage {
    Layer layer;
    PackageHead head;
    String data;
}
