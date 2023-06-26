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
        //test
        return new HostInfo("192.168.1.1","00-16-EA-AE-3C-40");
    }

    @Override
    public List<NetworkInterfacePackage> deliverData(String fromIp, String toIp, String data) {
        //test
        List<NetworkInterfacePackage> result = new ArrayList<>();
        result.add(Utils.testCaseGenerator());
        result.add(Utils.testCaseGenerator());
        return result;
    }

    @Override
    public List<NetworkInterfacePackage> packageInject(NetworkInterfacePackage networkInterfacePackage) {
        //test
        List<NetworkInterfacePackage> result = new ArrayList<>();
        result.add(networkInterfacePackage);
        return result;
    }

    @Override
    public List<NetworkInterfacePackage> ping(String fromIp, String toIp) {
        //test
        List<NetworkInterfacePackage> result = new ArrayList<>();
        result.add(Utils.testCaseGenerator());
        result.add(Utils.testCaseGenerator());
        return result;
    }
}
