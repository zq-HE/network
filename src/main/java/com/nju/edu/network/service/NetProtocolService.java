package com.nju.edu.network.service;

import com.nju.edu.network.entity.vo.HostInfo;
import com.nju.edu.network.entity.vo.packageFormat.NetworkInterfacePackage;

import java.util.List;

public interface NetProtocolService {
    /**
     *
     * @return HostInfo对象，每个String为十进制字符串，（进制转换和string解析使用Utils工具类完成即可）
     */
    HostInfo createEndpoint();

    /**
     *
     * @param fromIp  内容为十进制的字符串
     * @param toIp    内容为十进制的字符串
     * @param data    内容为十进制的字符串
     * @return        NetworkInterfacePackage对象列表，其中协议的每个字段都为十进制的字符串，data为编码了的字符串（进制转换和string解析使用Utils工具类完成即可）
     */
    List<NetworkInterfacePackage> deliverData(String fromIp, String toIp, String data);

    /**
     *
     * @param networkInterfacePackage NetworkInterfacePackage对象，其中协议的每个字段都为十进制的字符串，data为编码了的字符串（进制转换和string解析使用Utils工具类完成即可）
     * @return NetworkInterfacePackage对象列表，其中协议的每个字段都为十进制的字符串，data为编码了的字符串（进制转换和string解析使用Utils工具类完成即可）
     */
    List<NetworkInterfacePackage> packageInject(NetworkInterfacePackage networkInterfacePackage);

    /**
     *
     * @param fromIp   内容为十进制的字符串
     * @param toIp     内容为十进制的字符串
     * @return         NetworkInterfacePackage对象列表，其中协议的每个字段都为十进制的字符串，data为编码了的字符串（进制转换和string解析使用Utils工具类完成即可）
     */
    List<NetworkInterfacePackage> ping(String fromIp, String toIp);
}
