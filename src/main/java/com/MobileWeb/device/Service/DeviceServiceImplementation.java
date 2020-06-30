package com.MobileWeb.device.Service;

import com.MobileWeb.device.Repository.DeviceRepository;
import com.MobileWeb.device.io.entity.DeviceEntity;
import com.MobileWeb.device.shared.dto.DeviceDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImplementation implements DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public DeviceDto createDevice(DeviceDto device) {
        DeviceEntity deviceEntity=new DeviceEntity();
        BeanUtils.copyProperties(device,deviceEntity);
        DeviceEntity createdDevice=deviceRepository.save(deviceEntity);
        DeviceDto returnValue=new DeviceDto();
        BeanUtils.copyProperties(createdDevice,returnValue);
        return returnValue;
    }

    @Override
    public DeviceDto getDeviceById(long id) {
        DeviceEntity getDevice=deviceRepository.findDeviceByDeviceId(id);
        if(getDevice==null)
            throw new RuntimeException("No device found");
        DeviceDto returnValue=new DeviceDto();
        BeanUtils.copyProperties(getDevice,returnValue);
        return returnValue;
    }

    @Override
    public DeviceDto updateDevice(long deviceId, DeviceDto device) {
        DeviceDto deviceDto=new DeviceDto();
        DeviceEntity foundDevice=deviceRepository.findDeviceByDeviceId(deviceId);
        if(foundDevice==null)
            throw new RuntimeException("device not found");
        foundDevice.setName(device.getName());
        foundDevice.setEnrolledTime(device.getEnrolledTime());
        foundDevice.setModel(device.getModel());
        foundDevice.setStatus(device.getStatus());
        DeviceEntity updatedDevice=deviceRepository.save(foundDevice);
        BeanUtils.copyProperties(updatedDevice,deviceDto);
        return deviceDto;
    }

    @Override
    public DeviceDto deleteDevice(long deviceId) {
        DeviceDto deviceDto=new DeviceDto();
        DeviceEntity findDevice=deviceRepository.findDeviceByDeviceId(deviceId);
        if(findDevice==null) throw new RuntimeException("No device found");
        DeviceEntity deletedDevice=deviceRepository.deleteDeviceByDeviceId(deviceId);
        BeanUtils.copyProperties(deletedDevice,deviceDto);
        return deviceDto;

    }
}
