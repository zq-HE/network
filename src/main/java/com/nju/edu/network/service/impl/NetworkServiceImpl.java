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
        HostInfo hostInfo = netProtocolService.createEndpoint();
//        hostInfo.setIp(Utils.ip2To10(hostInfo.getIp()));
//        hostInfo.setMac(Utils.mac2To16(hostInfo.getMac()));
        return hostInfo;
    }

    @Override
    public List<NetworkInterfacePackage> deliverData(String fromIp, String toIp, String data) {
//        fromIp = Utils.ip10To2(fromIp);
//        toIp = Utils.ip10To2(toIp);
//        data = Utils.dataStringToBinary(data);
        List<NetworkInterfacePackage> networkInterfacePackages = netProtocolService.deliverData(fromIp, toIp, data);
//        transform(networkInterfacePackages);
        return networkInterfacePackages;
    }

    @Override
    public List<NetworkInterfacePackage> PackageInject(NetworkInterfacePackage networkInterfacePackage) {
//        Utils.setParentStringFieldsToBinary(networkInterfacePackage);
        List<NetworkInterfacePackage> networkInterfacePackages = netProtocolService.packageInject(networkInterfacePackage);
//        transform(networkInterfacePackages);
        return networkInterfacePackages;
    }

    @Override
    public List<NetworkInterfacePackage> ping(String fromIp, String toIp) {
//        fromIp = Utils.ip10To2(fromIp);
//        toIp = Utils.ip10To2(toIp);
        List<NetworkInterfacePackage> networkInterfacePackages = netProtocolService.ping(fromIp,toIp);
//        transform(networkInterfacePackages);
        return networkInterfacePackages;
    }

    @Override
    public void clear() {

    }

    private void transform(List<NetworkInterfacePackage> networkInterfacePackages){
        networkInterfacePackages.forEach(Utils::setParentStringFieldsToTen);
    }
}
