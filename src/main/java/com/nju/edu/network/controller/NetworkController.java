package com.nju.edu.network.controller;

import com.nju.edu.network.entity.vo.HostInfo;
import com.nju.edu.network.entity.vo.packageFormat.NetworkInterfacePackage;
import com.nju.edu.network.entity.vo.packageFormat.InjectDTO;
import com.nju.edu.network.entity.vo.packageFormat.NetworkPackage;
import com.nju.edu.network.entity.vo.packageFormat.TransportPackage;
import com.nju.edu.network.service.NetworkService;
import com.nju.edu.network.web.response.Response;
import com.nju.edu.network.web.response.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
@Slf4j
public class NetworkController {
    private final NetworkService networkService;

    @Autowired
    NetworkController(NetworkService networkService){
        this.networkService = networkService;
    }

    @PostMapping("/host")
    Response<HostInfo> createHost(){
        HostInfo host = networkService.createHost();
        return new Response<>(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), host);
    }

    @GetMapping("/deliver")
    Response<List<NetworkInterfacePackage>> deliverData(@RequestParam String fromIp, @RequestParam String toIp, @RequestParam String data){
        List<NetworkInterfacePackage> networkInterfacePackages = networkService.deliverData(fromIp, toIp, data);
        return new Response<>(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), networkInterfacePackages);
    }

    @PostMapping("/inject")
    Response<List<NetworkInterfacePackage>> inject(@RequestBody InjectDTO injectDTO){
        TransportPackage transportPackage = new TransportPackage(injectDTO.getUdpHead(),injectDTO.getData());
        NetworkPackage networkPackage = new NetworkPackage(injectDTO.getIpHead(), transportPackage);
        NetworkInterfacePackage networkInterfacePackage = new NetworkInterfacePackage(injectDTO.getFrameHead(),networkPackage);
        List<NetworkInterfacePackage> networkInterfacePackages = networkService.PackageInject(networkInterfacePackage);
        return new Response<>(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), networkInterfacePackages);
    }

    @GetMapping("/ping")
    Response<List<NetworkInterfacePackage>> ping(@RequestParam String fromIp, @RequestParam String toIp){
        List<NetworkInterfacePackage> networkInterfacePackages = networkService.ping(fromIp, toIp);
        return new Response<>(StatusCode.SUCCESS.getCode(), StatusCode.SUCCESS.getMessage(), networkInterfacePackages);
    }
}
