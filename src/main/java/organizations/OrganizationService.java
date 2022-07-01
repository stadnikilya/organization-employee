package organizations;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OrganizationService {

    public OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<Organization> list() {
        return organizationRepository.findAll();
    }

    public void add(Organization organization) {
        organizationRepository.save(organization);
    }

    public void delete(Long organizationId) {
        organizationRepository.deleteById(organizationId);
    }

    public void update(Organization organization) {
        Optional<Organization> organizationRow = organizationRepository.findById(organization.getId());
        if (organizationRow.isPresent()) {
            Organization item = organizationRow.get();
            if (!organization.getName().isEmpty()) {
                item.setName(organization.getName());
            }
            if (!organization.getAddress().isEmpty()) {
                item.setAddress(organization.getAddress());
            }
            organizationRepository.save(item);
        }
    }
}
