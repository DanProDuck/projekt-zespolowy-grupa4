/* Drop Tables */

DROP TABLE IF EXISTS "Address" CASCADE
;

DROP TABLE IF EXISTS "Author" CASCADE
;

DROP TABLE IF EXISTS "Bookmark" CASCADE
;

DROP TABLE IF EXISTS "Category" CASCADE
;

DROP TABLE IF EXISTS "Comment" CASCADE
;

DROP TABLE IF EXISTS "Order" CASCADE
;

DROP TABLE IF EXISTS "Person" CASCADE
;

DROP TABLE IF EXISTS "Product" CASCADE
;

DROP TABLE IF EXISTS "ProductCategory" CASCADE
;

DROP TABLE IF EXISTS "Registration" CASCADE
;

DROP TABLE IF EXISTS "Restoration" CASCADE
;

DROP TABLE IF EXISTS "Subscription" CASCADE
;

/* Create Tables */

CREATE TABLE "Address"
(
	"Additional_info" varchar(75) NULL,
	"City" varchar(50) NULL,
	"Country" varchar(30) NULL,
	"Details" varchar(50) NULL,
	"House_number" integer NULL,
	"Postal_code" varchar(12) NULL,
	"Street" varchar(100) NULL,
	"Street_number" varchar(12) NULL,
	"OrderID" integer NULL,
	"AddressID" integer NOT NULL GENERATED BY DEFAULT AS IDENTITY
)
;

CREATE TABLE "Author"
(
	"Alternative_name" varchar(50) NULL,
	"Author_info" varchar(200) NULL,
	"Date_of_birth" date NULL,
	"Date_of_death" date NULL,
	"Name" varchar(30) NULL,
	"Picture_blob" bytea NULL,
	"Picture_url" varchar(150) NULL,
	"Surname" varchar(50) NULL,
	"AuthorID" integer NOT NULL GENERATED BY DEFAULT AS IDENTITY
)
;

CREATE TABLE "Bookmark"
(
	"Created_at" timestamp without time zone NULL,
	"Description" varchar(50) NULL,
	"PersonID" integer NOT NULL,
	"BookmarkID" integer NOT NULL GENERATED BY DEFAULT AS IDENTITY
)
;

CREATE TABLE "Category"
(
	"Category_name" varchar(50) NULL,
	"Description" varchar(75) NULL,
	"Type" varchar(20) NOT NULL,
	"CategoryID" integer NOT NULL GENERATED BY DEFAULT AS IDENTITY
)
;

CREATE TABLE "Comment"
(
	"Content" varchar(200) NOT NULL,
	"Created_at" timestamp without time zone NULL,
	"Rating" integer DEFAULT 0 NULL,
	"PersonID" integer NOT NULL,
	"CommentID" integer NOT NULL GENERATED BY DEFAULT AS IDENTITY
)
;

CREATE TABLE "Order"
(
	"Date_due_to" date NULL,
	"Date_rent_from" date NULL,
	"Description" varchar(150) NULL,
	"Order_date" date NULL,
	"Quantity" integer NULL,
	"Status" varchar(20) NULL,
	"Type" varchar(5) NULL,
	"PersonID" integer NOT NULL,
	"OrderID" integer NOT NULL GENERATED BY DEFAULT AS IDENTITY
	/* "AddressID" as foreign? */
)
;

CREATE TABLE "Person"
(
	"Created_at" timestamp without time zone NULL,
	"Email" varchar(60) NULL,
	"Is_enabled" boolean NULL,
	"Is_restricted" boolean NULL,
	"Name" varchar(30) NULL,
	"Password" varchar(75) NULL,
	"Phone_number" integer NULL,
	"Role" varchar(17) NULL,
	"Surname" varchar(50) NULL,
	"Updated_at" timestamp without time zone NULL,
	"Username" varchar(30) NULL,
	"BookmarkID" integer NULL,
	"CommentID" integer NULL,
	"PersonID" integer NOT NULL GENERATED BY DEFAULT AS IDENTITY
	/* "AddressID" as foreign? */
)
;

CREATE TABLE "Product"
(
	"Buy_price" numeric NULL,
	"Date_of_issue" date NULL,
	"Description" varchar(50) NULL,
	"Picture_blob" bytea NULL,
	"Picture_url" varchar(50) NULL,
	"Quantity" integer NULL,
	"Rating" numeric NULL,
	"Rent_price" numeric NULL,
	"Title" varchar(50) NULL,
	"Type" varchar(50) NULL,
	"AuthorID" integer NOT NULL,
	"BookmarkID" integer NULL,
	"CommentID" integer NULL,
	"OrderID" integer NULL,
	"ProductID" integer NOT NULL GENERATED BY DEFAULT AS IDENTITY
)
;

CREATE TABLE "ProductCategory"
(
	"CategoryID" integer NOT NULL,
	"ProductID" integer NOT NULL
)
;

CREATE TABLE "Registration"
(
	"Registrated_at" timestamp without time zone NULL,
	"Registration_token" varchar(75) NULL,
	"PersonID" integer NOT NULL,
	"RegistrationID" integer NOT NULL GENERATED BY DEFAULT AS IDENTITY
)
;

CREATE TABLE "Restoration"
(
	"Reset_at" timestamp without time zone NULL,
	"Reset_token" varchar(75) NULL,
	"PersonID" integer NOT NULL,
	"RestorationID" integer NOT NULL GENERATED BY DEFAULT AS IDENTITY
)
;

CREATE TABLE "Subscription"
(
	"Subscribed_at" timestamp without time zone NULL,
	"Subscription_token" varchar(75) NULL,
	"Subscription_type" varchar(10) NULL,
	"PersonID" integer NOT NULL,
	"SubscriptionID" integer NOT NULL GENERATED BY DEFAULT AS IDENTITY
)
;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE "Address" ADD CONSTRAINT "PK_Address"
	PRIMARY KEY ("AddressID")
;

ALTER TABLE "Author" ADD CONSTRAINT "PK_Author"
	PRIMARY KEY ("AuthorID")
;

ALTER TABLE "Bookmark" ADD CONSTRAINT "PK_Bookmark"
	PRIMARY KEY ("BookmarkID")
;

ALTER TABLE "Category" ADD CONSTRAINT "PK_Category"
	PRIMARY KEY ("CategoryID")
;

ALTER TABLE "Comment" ADD CONSTRAINT "PK_Comment"
	PRIMARY KEY ("CommentID")
;

ALTER TABLE "Order" ADD CONSTRAINT "PK_Order"
	PRIMARY KEY ("OrderID")
;

ALTER TABLE "Person" ADD CONSTRAINT "PK_Person"
	PRIMARY KEY ("PersonID")
;

ALTER TABLE "Product" ADD CONSTRAINT "PK_Product"
	PRIMARY KEY ("ProductID")
;

ALTER TABLE "Registration" ADD CONSTRAINT "PK_Registration"
	PRIMARY KEY ("RegistrationID")
;

ALTER TABLE "Restoration" ADD CONSTRAINT "PK_Restoration"
	PRIMARY KEY ("RestorationID")
;

ALTER TABLE "Subscription" ADD CONSTRAINT "PK_Subscription"
	PRIMARY KEY ("SubscriptionID")
;

/* Create Foreign Key Constraints */

ALTER TABLE "Address" ADD CONSTRAINT "FK_Address_Order"
	FOREIGN KEY ("OrderID") REFERENCES "Order" ("OrderID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Bookmark" ADD CONSTRAINT "FK_Bookmark_Person"
	FOREIGN KEY ("PersonID") REFERENCES "Person" ("PersonID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Comment" ADD CONSTRAINT "FK_Comment_Person"
	FOREIGN KEY ("PersonID") REFERENCES "Person" ("PersonID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Order" ADD CONSTRAINT "FK_Order_Person"
	FOREIGN KEY ("PersonID") REFERENCES "Person" ("PersonID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Product" ADD CONSTRAINT "FK_Product_Author"
	FOREIGN KEY ("AuthorID") REFERENCES "Author" ("AuthorID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Product" ADD CONSTRAINT "FK_Product_Bookmark"
	FOREIGN KEY ("BookmarkID") REFERENCES "Bookmark" ("BookmarkID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Product" ADD CONSTRAINT "FK_Product_Comment"
	FOREIGN KEY ("CommentID") REFERENCES "Comment" ("CommentID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Product" ADD CONSTRAINT "FK_Product_Order"
	FOREIGN KEY ("OrderID") REFERENCES "Order" ("OrderID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "ProductCategory" ADD CONSTRAINT "FK_productcategory_category"
	FOREIGN KEY ("CategoryID") REFERENCES "Category" ("CategoryID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "ProductCategory" ADD CONSTRAINT "FK_productcategory_product"
	FOREIGN KEY ("ProductID") REFERENCES "Product" ("ProductID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Registration" ADD CONSTRAINT "FK_Registration_Person"
	FOREIGN KEY ("PersonID") REFERENCES "Person" ("PersonID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Restoration" ADD CONSTRAINT "FK_Restoration_Person"
	FOREIGN KEY ("PersonID") REFERENCES "Person" ("PersonID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Subscription" ADD CONSTRAINT "FK_Subscription_Person"
	FOREIGN KEY ("PersonID") REFERENCES "Person" ("PersonID") ON DELETE No Action ON UPDATE No Action
;

/* Create Primary Keys Constraints for Junction Tables */

ALTER TABLE "ProductCategory" ADD CONSTRAINT "PK_productcategory"
	PRIMARY KEY ("CategoryID", "ProductID")
;
