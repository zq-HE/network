package com.nju.edu.network.service.impl;

import com.nju.edu.network.entity.vo.HostInfo;
import com.nju.edu.network.entity.vo.packageFormat.NetworkInterfacePackage;
import com.nju.edu.network.service.NetProtocolService;
import com.nju.edu.network.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NetProtocolAdaptor implements NetProtocolService {
    @Override
    public HostInfo createEndpoint() {
        return null;
    }

    @Override
    public List<NetworkInterfacePackage> deliverData(String fromIp, String fromPort,String toIp, String toPort,String data) {
        return null;
    }

    @Override
    public List<NetworkInterfacePackage> packageInject(NetworkInterfacePackage networkInterfacePackage) {
        return null;
    }

    @Override
    public List<NetworkInterfacePackage> ping(String fromIp, String toIp) {
        return null;
    }
}
