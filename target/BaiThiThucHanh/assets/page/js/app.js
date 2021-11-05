class User {

    constructor(id,  name,  userName,  password,  role,  phone,  address,  email,  image,  createdAt,  isDelete,  salary,  revenue,  business) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.image = image;
        this.createdAt = createdAt;
        this.isDelete = isDelete;
        this.salary = salary;
        this.revenue = revenue;
        this.business = business;
    }
}

class Product {
    constructor( id,  name,  description,  createdAt,  image,  price,  accede,  quantity, category, company) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.image = image;
        this.price = price;
        this.accede = accede;
        this.quantity = quantity;
        this.category = category;
        this.company = company;
    }

}


class Category {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
}

class Company {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
}

class LocationRegion {
    constructor(id, provinceId, provinceName, districtId, districtName, wardId, wardName) {
        this.id = id;
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.districtId = districtId;
        this.districtName = districtName;
        this.wardId = wardId;
        this.wardName = wardName;
    }
}

class Country {
    constructor(id, name) {
        this.id = id;
        this.name = name;
    }
}

class Province {
    constructor(id,provinceName,  country,  area,  population,  GDP,  description ) {
        this.id = id;
        this.provinceName = provinceName;
        this.country = country;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.description = description;
    }

}