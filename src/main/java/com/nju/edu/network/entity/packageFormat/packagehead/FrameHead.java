package com.nju.edu.network.entity.packageFormat.packagehead;

import com.nju.edu.network.entity.packageFormat.PackageHead;

public class FrameHead extends PackageHead {
    String destinationMacAddress;
    String sourceMacAddress;
    String etherType;
    //注意，这里将尾部的FCS提到了Head中来存放
    String FCS;
}
