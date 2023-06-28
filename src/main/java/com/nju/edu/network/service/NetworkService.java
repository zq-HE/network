package com.nju.edu.network.service;

import com.nju.edu.network.entity.vo.HostInfo;
import com.nju.edu.network.entity.vo.packageFormat.NetworkInterfacePackage;

import java.util.List;

public interface NetworkService {
    HostInfo createHost();

    List<NetworkInterfacePackage> deliverData(String fromIp, String fromPort,String toIp, String toPort,String data);

    List<NetworkInterfacePackage> PackageInject(NetworkInterfacePackage networkInterfacePackage);

    List<NetworkInterfacePackage> ping(String fromIp, String toIp);

    void clear();
}
