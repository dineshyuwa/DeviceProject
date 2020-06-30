package com.MobileWeb.device.Repository;

import com.MobileWeb.device.io.entity.DeviceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends CrudRepository<DeviceEntity,Long> {
    DeviceEntity findDeviceByDeviceId(long deviceId);
    DeviceEntity deleteDeviceByDeviceId(long deviceId);
}
