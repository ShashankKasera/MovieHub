package com.codeinglogs.presentation.model.person.personenum

import com.codeinglogs.domain.model.person.personenum.PersonType as DomainPersonType
enum class PersonType {
    POPULAR,SEARCH
}


fun PersonType.toDomainPersonType()= when(this){
    PersonType.POPULAR -> DomainPersonType.POPULAR
    PersonType.SEARCH -> DomainPersonType.SEARCH
}