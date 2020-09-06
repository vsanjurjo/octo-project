package com.octo.project.startproject.respositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.octo.project.startproject.entities.Device;
import com.octo.project.startproject.repositories.DeviceRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DeviceRespositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private DeviceRepository deviceRepository;

	@Test
	public void whenFindByNameContainingOrModelContaining_thenReturnDevice() {
		// given
		Device device = new Device("Arduino", "Uno R3");
		entityManager.persist(device);
		entityManager.flush();

		// when
		List<Device> foundList = deviceRepository.findByNameContainingOrModelContaining(device.getName(),
				device.getModel());

		// then
		for (Device found : foundList) {
			assertThat(found.getName()).contains(device.getName());
		}

	}

}
