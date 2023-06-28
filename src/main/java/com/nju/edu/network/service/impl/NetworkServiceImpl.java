package com.nju.edu.network.service.impl;

import com.nju.edu.network.entity.vo.HostInfo;
import com.nju.edu.network.entity.vo.packageFormat.NetworkInterfacePackage;
import com.nju.edu.network.service.NetProtocolService;
import com.nju.edu.network.service.NetworkService;
import com.nju.edu.network.utils.Utils;
import org.springframework.stereotype.Service;
import org.springframework.ui.context.support.UiApplicationContextUtils;

import java.util.List;

@Service
public class NetworkServiceImpl implements NetworkService {
    private final NetProtocolService netProtocolService;

    public NetworkServiceImpl(NetProtocolService netProtocolService) {
        this.netProtocolService = netProtocolService;
    }

    @Override
    public HostInfo createHost() {
        return netProtocolService.createEndpoint();
    }

    @Override
    public List<NetworkInterfacePackage> deliverData(String fromIp, String fromPort,String toIp, String toPort,String data) {
        return netProtocolService.deliverData(fromIp, fromPort,toIp, toPort,data);
    }

    @Override
    public List<NetworkInterfacePackage> PackageInject(NetworkInterfacePackage networkInterfacePackage) {
        return netProtocolService.packageInject(networkInterfacePackage);
    }

    @Override
    public List<NetworkInterfacePackage> ping(String fromIp, String toIp) {
        return netProtocolService.ping(fromIp,toIp);
    }

    @Override
    public void clear() {

    }

    private void transform(List<NetworkInterfacePackage> networkInterfacePackages){
        networkInterfacePackages.forEach(Utils::setParentStringFieldsToTen);
    }
}
