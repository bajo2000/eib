package codingdojo;

public class CustomerSync {

    private final CustomerMatchesService customerMatchesService;
    private final CustomerUpdateService customerUpdateService;

    public CustomerSync(CustomerMatchesService customerMatchesService, CustomerUpdateService customerUpdateService) {
        this.customerMatchesService = customerMatchesService;
        this.customerUpdateService = customerUpdateService;
    }

    public boolean syncWithDataLayer(ExternalCustomer externalCustomer) {
        CustomerMatches customerMatches = customerMatchesService.load(externalCustomer);

        return customerUpdateService.update(externalCustomer, customerMatches);
    }
}
