package fr.insee.bar.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import fr.insee.bar.model.Employe;
import fr.insee.bar.repository.EmployeRepository;

@Profile("responsable")
@Component
public class ResponsableProvider implements EmployeProvider {

	@Autowired
	private EmployeRepository employeRepository;

	@Override
	public Employe provide() {
		return employeRepository.findById(Short.valueOf("3")).get();
	}

}
