package com.king.request;//package com.king.batch.request;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.Callable;
//import java.util.concurrent.Future;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.znv.cop.ods.inf.req.xc.XCDeviceIdDto;
//import com.znv.cop.ods.result.vo.XCResponse;
//import com.znv.cop.ods.result.vo.XCResponseVO;
//import com.znv.cop.ods.util.ThreadPoolUtil;
//
//@Service
//public class XCUnitBuildingService {
//
//    @Autowired
//    XCRemoteService remoteService;
//
//    @Autowired
//    XCUnitBuildingDao unitBuildingDao;
//    
//    public void syncUnitBuilding() {
//
//        List<String> deviceList = unitBuildingDao.emptyUnitDevices();
//
//        while (deviceList.size() == 600) {
//            deviceList.clear();
//            deviceList = unitBuildingDao.emptyUnitDevices();
//            execute(deviceList);            
//        }
//        
//    }
//
//    public void execute(List<String> deviceList) {
//        Map<String, Future<XCDeviceRspDto>> futureMap = new HashMap<>();
//
//        for (String device : deviceList) {
//            futureMap.put(device, ThreadPoolUtil.submit(device, new Callable<XCDeviceRspDto>() {
//                @Override
//                public XCDeviceRspDto call() throws Exception {
//                    try {
//                        XCResponseVO<XCDeviceRspDto> responseVO = remoteService
//                                .queryDeviceDetail(new XCDeviceIdDto(device));
//                        if (responseVO != null && responseVO.isResponseSuccess()) {
//                            return responseVO.getData();
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    return null;
//                }
//            }));
//        }
//
//        List<XCDeviceRspDto> deviceRspDtos = new ArrayList<>(deviceList.size());
//        for (Future<XCDeviceRspDto> future : futureMap.values()) {
//            try {
//                if (future != null && future.get() != null && future.get().getUnit() != null) {
//                    deviceRspDtos.add(future.get());
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        try {
//            unitBuildingDao.batchFillUnit(deviceRspDtos);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//}
