package com.example.ecommercespring.gateway;

import com.example.ecommercespring.dto.FakeStoreProductResponseDTO;
import com.example.ecommercespring.dto.ProductDto;
import com.example.ecommercespring.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Component;

@Component
public class FakeStoreProductGateway implements IProductGateway {
    private final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }

    @Override
    public ProductDto getProductById(Long id) throws Exception {
        FakeStoreProductResponseDTO response = this.fakeStoreProductApi.getFakeProduct(id).execute().body();

        if (response == null) {
            throw new Exception("Product not found");
        }
        return response.getProduct();
    }
}
