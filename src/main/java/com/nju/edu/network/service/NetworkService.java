package com.nju.edu.network.service;

import com.nju.edu.network.entity.vo.HostInfo;
import com.nju.edu.network.entity.vo.NetPackage;

import java.util.List;

public interface NetworkService {
    HostInfo createHost(String ip);
    List<NetPackage> getPackageByIp(String fromIp, String toIp);
    List<NetPackage> PackageInject(NetPackage netPackage);
    List<NetPackage> ping(String fromIp, String toIp);
}
