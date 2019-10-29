package com.king.request;//package com.znv.cop.ods.inf.service;
//
//import java.net.URI;
//import java.util.Collections;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
//import org.springframework.context.annotation.Import;
//import org.springframework.stereotype.Service;
//
//import com.znv.cop.ods.config.xc.XCRequestConfig;
//import com.znv.cop.ods.enums.XCApiNameEnum;
//import com.znv.cop.ods.exception.BusinessException;
//import com.znv.cop.ods.exception.ErrorCodeDefinition;
//import com.znv.cop.ods.inf.req.xc.XCAccountReqDto;
//import com.znv.cop.ods.inf.req.xc.XCDeviceIdDto;
//import com.znv.cop.ods.inf.req.xc.XCDeviceListReqDto;
//import com.znv.cop.ods.inf.req.xc.XCDeviceSchemeReqDto;
//import com.znv.cop.ods.inf.req.xc.XCItemReqDto;
//import com.znv.cop.ods.inf.req.xc.XCWoNotifyReqDto;
//import com.znv.cop.ods.inf.rsp.xc.DevelopStaffRspDto;
//import com.znv.cop.ods.inf.rsp.xc.XCDeviceRspDto;
//import com.znv.cop.ods.inf.rsp.xc.XCDeviceSchemeRspDto;
//import com.znv.cop.ods.inf.rsp.xc.XCItemRspDto;
//import com.znv.cop.ods.result.vo.Response;
//import com.znv.cop.ods.result.vo.XCResponse;
//import com.znv.cop.ods.result.vo.XCResponseVO;
//import com.znv.cop.ods.service.xc.XCUrlService;
//import com.znv.cop.ods.util.JSONUtils;
//import com.znv.cop.ods.util.ObjectUtils;
//
//import feign.Feign;
//import feign.Target;
//import feign.codec.Decoder;
//import feign.codec.Encoder;
//
//@Service
//@Import(FeignClientsConfiguration.class)
//public class XCRemoteService {
//
//	@Autowired
//	XCUrlService xcUrlService;
//
//	XCFeignClient xcFeignClient;
//
//	@Autowired
//	public XCRemoteService(Decoder decoder, Encoder encoder) {
//		xcFeignClient = Feign.builder().encoder(encoder).decoder(decoder)
//				.target(Target.EmptyTarget.create(XCFeignClient.class));
//	}
//
//	/**
//	 * 接口校验
//	 * 
//	 * @param checkDto
//	 * @return
//	 */
//	public XCResponse checkSign(Object checkDto) {
//		URI checkSignURI = xcUrlService.combineXCUri(XCApiNameEnum.Sign_Check, ObjectUtils.toParamMap(checkDto));
//		XCResponse xcRsp = xcFeignClient.signCheck(checkSignURI, ObjectUtils.toParamMap(checkDto));
//		return xcRsp;
//	}
//
//	/**
//	 * 设备详情
//	 * 
//	 * @param idDto
//	 * @return
//	 */
//	public XCResponseVO<XCDeviceRspDto> queryDeviceDetail(XCDeviceIdDto idDto) {
//		URI deviceURI = xcUrlService.combineXCUri(XCApiNameEnum.Device_Detail, ObjectUtils.toParamMap(idDto));
//		XCResponse xcRsp = xcFeignClient.queryDeviceDetail(deviceURI);
//		XCResponseVO<XCDeviceRspDto> xcRspVO = convertXCRsp(xcRsp, XCDeviceRspDto.class);
//		if (isDataSuccess(xcRsp)) {
//			XCDeviceRspDto generalDto = JSONUtils.jsonStringToObject(JSONUtils.objectToJsonString(xcRsp.getData()),
//					XCDeviceRspDto.class);
//			xcRspVO.setData(generalDto);
//		}
//
//		return xcRspVO;
//	}
//
//	/**
//	 * 设备列表
//	 * 
//	 * @param dvListDto
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public XCResponseVO<List<XCDeviceRspDto>> queryDeviceList(XCDeviceListReqDto dvListDto) {
//		URI dvListURI = xcUrlService.combineXCUri(XCApiNameEnum.Device_List, ObjectUtils.toParamMap(dvListDto));
//		XCResponse xcRsp = xcFeignClient.queryDeviceList(dvListURI);
//		XCResponseVO<List<XCDeviceRspDto>> xcRspVO = convertXCRsp(xcRsp,
//				(Class<List<XCDeviceRspDto>>) Collections.emptyList().getClass());
//		if (isDataSuccess(xcRsp)) {
//			List<XCDeviceRspDto> generalDto = JSONUtils.jsonStringToList(JSONUtils.objectToJsonString(xcRsp.getData()),
//					XCDeviceRspDto.class);
//			xcRspVO.setData(generalDto);
//		}
//
//		return xcRspVO;
//	}
//
//	/**
//	 * 项目列表
//	 * 
//	 * @param itemReqDto
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public XCResponseVO<List<XCItemRspDto>> queryItems(XCItemReqDto itemReqDto) {
//		URI itemsURI = xcUrlService.combineXCUri(XCApiNameEnum.Item_List, ObjectUtils.toParamMap(itemReqDto));
//		XCResponse xcRsp = xcFeignClient.queryItems(itemsURI);
//		XCResponseVO<List<XCItemRspDto>> xcRspVO = convertXCRsp(xcRsp,
//				(Class<List<XCItemRspDto>>) Collections.emptyList().getClass());
//
//		if (isDataSuccess(xcRsp)) {
//			List<XCItemRspDto> generalDto = JSONUtils.jsonStringToList(JSONUtils.objectToJsonString(xcRsp.getData()),
//					XCItemRspDto.class);
//			xcRspVO.setData(generalDto);
//		}
//
//		return xcRspVO;
//	}
//
//	/**
//	 * 工单完成、取消返回
//	 * 
//	 * @param woReqDto
//	 * @return
//	 */
//	public XCResponse woNotify(XCWoNotifyReqDto woReqDto) {
//		URI norifyURI = xcUrlService.combineXCUri(XCApiNameEnum.Workorder_Callback, ObjectUtils.toParamMap(woReqDto));
//		XCResponse xcRsp = xcFeignClient.woNotify(norifyURI);
//
//		return xcRsp;
//	}
//
//	/**
//	 * 设备组织架构
//	 * 
//	 * @param dvSchemeReqDto
//	 * @return
//	 */
//	@SuppressWarnings("unchecked")
//	public XCResponseVO<List<XCDeviceSchemeRspDto>> queryDeviceScheme(XCDeviceSchemeReqDto dvSchemeReqDto) {
//		URI dvSchemeURI = xcUrlService.combineXCUri(XCApiNameEnum.Device_Scheme,
//				ObjectUtils.toParamMap(dvSchemeReqDto));
//		XCResponse xcRsp = xcFeignClient.queryDeviceScheme(dvSchemeURI);
//		XCResponseVO<List<XCDeviceSchemeRspDto>> xcRspVO = convertXCRsp(xcRsp,
//				(Class<List<XCDeviceSchemeRspDto>>) Collections.emptyList().getClass());
//
//		if (isDataSuccess(xcRsp)) {
//			List<XCDeviceSchemeRspDto> generalDto = JSONUtils
//					.jsonStringToList(JSONUtils.objectToJsonString(xcRsp.getData()), XCDeviceSchemeRspDto.class);
//			xcRspVO.setData(generalDto);
//		}
//
//		return xcRspVO;
//
//	}
//
//	// CRM
//	public XCResponseVO<DevelopStaffRspDto> queryDeveloper(XCAccountReqDto devReqDto) {
//		URI developerURI = xcUrlService.combineXCUri(XCApiNameEnum.Developer, ObjectUtils.toParamMap(devReqDto));
//		XCResponse xcRsp = xcFeignClient.queryDeveloper(developerURI);
//
//		XCResponseVO<DevelopStaffRspDto> xcRspVO = convertXCRsp(xcRsp, DevelopStaffRspDto.class);
//		if (isDataSuccess(xcRsp)) {
//			DevelopStaffRspDto generalDto = JSONUtils.jsonStringToObject(JSONUtils.objectToJsonString(xcRsp.getData()),
//					DevelopStaffRspDto.class);
//			xcRspVO.setData(generalDto);
//		}
//
//		return xcRspVO;
//	}
//
//	/**
//	 * support APS
//	 */
//	public Response gwDeviceList(XCDeviceListReqDto dvListDto) {
//		XCResponseVO<List<XCDeviceRspDto>> xcRsp = queryDeviceList(dvListDto);
//		return xcRspProcess(xcRsp);
//	}
//
//	public Response gwDeviceDetail(XCDeviceIdDto idDto) {
//		XCResponseVO<XCDeviceRspDto> xcRsp = queryDeviceDetail(idDto);
//		Response response = xcRspProcess(xcRsp);
//		if (xcRsp.getData().getDeviceId() == null) {
//			throw new BusinessException(ErrorCodeDefinition.DEVICE_NOT_EXISTS.getErrorCode());
//		}
//
//		return response;
//	}
//
//	public Response gwItems(XCItemReqDto itemReqDto) {
//		XCResponseVO<List<XCItemRspDto>> xcRsp = queryItems(itemReqDto);
//		return xcRspProcess(xcRsp);
//	}
//
//	public Response gwDeveloper(XCAccountReqDto devReqDto) {
//		XCResponseVO<DevelopStaffRspDto> xcRsp = queryDeveloper(devReqDto);
//		return xcRspProcess(xcRsp);
//	}
//
//	public Response gwDeviceScheme(XCDeviceSchemeReqDto dvSchemeReqDto) {
//		XCResponseVO<List<XCDeviceSchemeRspDto>> xcRsp = queryDeviceScheme(dvSchemeReqDto);
//		return xcRspProcess(xcRsp);
//	}
//
//	/*******************
//	 * Auxiliary Methods conversion for aps invoke
//	 * 
//	 * @param xcRsp
//	 * @return
//	 */
//	public Response xcRspProcess(XCResponseVO<?> xcRsp) {
//		Response response = new Response();
//		if (xcRsp.isResponseSuccess() && (XCRequestConfig.SSP_BIZ_SUCCESS.equals(xcRsp.getBiz_code())
//				|| XCRequestConfig.CRM_BIZ_SUCCESS.equals(xcRsp.getBiz_code()))) {
//			response.setData(xcRsp.getData());
//		} else {
//			response.setErrCode(-1);
//			response.setSuccess(false);
//			response.setMsg(xcRsp.getMsg());
//		}
//
//		return response;
//	}
//
//	/**
//	 * format XC return data
//	 * 
//	 * @param xcRsp
//	 * @param dataClass
//	 * @return
//	 */
//	private <T> XCResponseVO<T> convertXCRsp(XCResponse xcRsp, Class<T> dataClass) {
//		XCResponseVO<T> rspVO = new XCResponseVO<>();
//		rspVO.setBiz_code(xcRsp.getBiz_code());
//		rspVO.setCode(xcRsp.getCode());
//		rspVO.setMsg(xcRsp.getMsg());
//
//		return rspVO;
//	}
//
//	/**
//	 * judge whether XC data success
//	 * 
//	 * @param rsp
//	 * @return
//	 */
//	private boolean isDataSuccess(XCResponse rsp) {
//		if (rsp.isResponseSuccess() && rsp.getData() != null
//				&& (XCRequestConfig.SSP_BIZ_SUCCESS.equals(rsp.getBiz_code())
//						|| XCRequestConfig.CRM_BIZ_SUCCESS.equals(rsp.getBiz_code()))) {
//			return true;
//		}
//
//		return false;
//	}
//
//}
