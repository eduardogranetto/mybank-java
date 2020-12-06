CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table account (
	id uuid primary key default uuid_generate_v4(),
	document_number text not null,
	unique(document_number)
);

create table  "transaction" (
	id uuid primary key default uuid_generate_v4(),
	account_id uuid not null,
	operation_type text not null,
	amount numeric(12,2) not null ,
	event_date timestamp default now(),
  constraint transaction_account_id foreign key (account_id) references account(id)
);
