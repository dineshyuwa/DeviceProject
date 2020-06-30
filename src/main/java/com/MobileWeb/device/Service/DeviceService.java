package com.MobileWeb.device.Service;

import com.MobileWeb.device.shared.dto.DeviceDto;

public interface DeviceService {
    DeviceDto createDevice(DeviceDto device);
    DeviceDto getDeviceById(long deviceId);
    DeviceDto updateDevice(long deviceId,DeviceDto device);
    DeviceDto deleteDevice(long deviceId);
}
