package com.nju.edu.network.entity.vo.packageFormat;

import com.nju.edu.network.entity.vo.packageFormat.packagehead.PackageHead;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NetworkInterfacePackage {
    PackageHead head;
    NetworkPackage data;

    public static String NetworkInterfacePackageToBinary(NetworkInterfacePackage networkInterfacePackage){
        //todo
        return null;
    }

    public static NetworkInterfacePackage BinaryToNetworkInterfacePackage(String binary){
        //todo
        return null;
    }
}
