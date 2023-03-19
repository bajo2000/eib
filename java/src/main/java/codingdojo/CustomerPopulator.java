package codingdojo;

import java.util.Objects;

public class CustomerPopulator {

    public Customer populate(ExternalCustomer externalCustomer, Customer customer) {
        customer = populateFields(externalCustomer, customer);
        customer = updateContactInfo(externalCustomer, customer);
        customer = updatePreferredStore(externalCustomer, customer);

        return customer;
    }

    private Customer populateFields(ExternalCustomer externalCustomer, Customer customer) {
        customer.setName(externalCustomer.getName());
        if (externalCustomer.isCompany()) {
            customer.setCompanyNumber(externalCustomer.getCompanyNumber());
            customer.setCustomerType(CustomerType.COMPANY);
        } else {
            customer = updateBonusPointsBalance(externalCustomer, customer);
            customer.setCustomerType(CustomerType.PERSON);
        }
        return customer;
    }

    private Customer updateBonusPointsBalance(ExternalCustomer externalCustomer, Customer customer) {
        if (!Objects.equals(externalCustomer.getBonusPointsBalance(), customer.getBonusPointsBalance())) {
            customer.setBonusPointsBalance(externalCustomer.getBonusPointsBalance());
        }
        return customer;
    }

    private Customer updatePreferredStore(ExternalCustomer externalCustomer, Customer customer) {
        customer.setPreferredStore(externalCustomer.getPreferredStore());
        return customer;
    }


    private Customer updateContactInfo(ExternalCustomer externalCustomer, Customer customer) {
        customer.setAddress(externalCustomer.getPostalAddress());
        return customer;
    }
}
