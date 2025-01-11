package com.ust.Spring_Reactive.Repository;

import com.ust.Spring_Reactive.entity.Invoice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface InvoiceRepo extends ReactiveMongoRepository<Invoice,String> {
}
