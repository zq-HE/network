package com.nju.edu.network.service.impl;

import com.nju.edu.network.entity.vo.HostInfo;
import com.nju.edu.network.entity.vo.NetPackage;
import com.nju.edu.network.service.NetProtocolService;
import com.nju.edu.network.service.NetworkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetworkServiceImpl implements NetworkService {
    private final NetProtocolService netProtocolService;
    public NetworkServiceImpl(NetProtocolService netProtocolService){
        this.netProtocolService = netProtocolService;
    }

    @Override
    public HostInfo createHost(String ip) {
        return null;
    }

    @Override
    public List<NetPackage> getPackageByIp(String fromIp, String toIp) {
        return null;
    }

    @Override
    public List<NetPackage> PackageInject(NetPackage netPackage) {
        return null;
    }

    @Override
    public List<NetPackage> ping(String fromIp, String toIp) {
        return null;
    }
}
