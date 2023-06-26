package com.nju.edu.network.entity.vo.packageFormat;

import com.nju.edu.network.entity.vo.packageFormat.packagehead.FrameHead;
import com.nju.edu.network.entity.vo.packageFormat.packagehead.IpHead;
import com.nju.edu.network.entity.vo.packageFormat.packagehead.UdpHead;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class InjectDTO {
    String data;
    FrameHead frameHead;
    IpHead ipHead;
    UdpHead udpHead;
}
