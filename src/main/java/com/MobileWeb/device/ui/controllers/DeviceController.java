package com.MobileWeb.device.ui.controllers;

import com.MobileWeb.device.Service.DeviceService;
import com.MobileWeb.device.shared.dto.DeviceDto;
import com.MobileWeb.device.ui.model.request.DeviceRequestModel;
import com.MobileWeb.device.ui.model.response.DeviceResponseModel;
import com.MobileWeb.device.ui.model.response.GetDeviceResponseModel;
import com.MobileWeb.device.ui.model.response.ResponseMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("devices")
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @GetMapping(path ="/{deviceId}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public GetDeviceResponseModel getDevice(@PathVariable long deviceId){
        GetDeviceResponseModel getDeviceResponseModel=new GetDeviceResponseModel();
        DeviceDto deviceDto=deviceService.getDeviceById(deviceId);
        BeanUtils.copyProperties(deviceDto,getDeviceResponseModel);
        return getDeviceResponseModel;
    }

    @PostMapping(produces={MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
    public DeviceResponseModel createDevice(@RequestBody DeviceRequestModel deviceRequestModel){
        DeviceResponseModel returnValue=new DeviceResponseModel();
        DeviceDto deviceDto=new DeviceDto();
        System.out.println(deviceRequestModel.getEnrolledTime());
        BeanUtils.copyProperties(deviceRequestModel,deviceDto);
        System.out.println(deviceDto.getEnrolledTime());
        DeviceDto createdDevice=deviceService.createDevice(deviceDto);
        BeanUtils.copyProperties(createdDevice,returnValue);
        return returnValue;
    }

    @PutMapping(path ="/{deviceId}" ,produces={MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
    public DeviceResponseModel updateDevice(@PathVariable long deviceId,@RequestBody DeviceRequestModel deviceRequestModel){
        DeviceResponseModel returnValue=new DeviceResponseModel();
        DeviceDto deviceDto=new DeviceDto();
        BeanUtils.copyProperties(deviceRequestModel,deviceDto);
        DeviceDto updateDevice=deviceService.updateDevice(deviceId,deviceDto);
        BeanUtils.copyProperties(updateDevice,returnValue);
        return returnValue;
    }

    @DeleteMapping(path ="/{deviceId}" ,produces={MediaType.APPLICATION_JSON_VALUE})
    public ResponseMessage deleteDevice(@PathVariable long deviceId){
        ResponseMessage responseMessage=new ResponseMessage();
        DeviceDto deletedDevice=deviceService.deleteDevice(deviceId);
        responseMessage.setStatusCode(200);
        responseMessage.setMessage("Deleted Successfully");
        return responseMessage;
    }

}
