package com.lunatech.utils;

import com.lunatech.model.NameBasics;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;

@Converter
public class NameBasicsConverter implements AttributeConverter<List<NameBasics>, String> {
    private static final String SEPARATOR = ",";

    @Override
    public String convertToDatabaseColumn(List<NameBasics> attribute) {
        if (attribute == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (NameBasics nameBasic : attribute) {
            if (nameBasic.getNconst() != null && !nameBasic.getNconst()
                    .isEmpty()) {
                sb.append(nameBasic.getNconst());
                sb.append(SEPARATOR);
            }
        }
        return sb.toString();
    }

    @Override
    public List<NameBasics> convertToEntityAttribute(String dbData) {
        List<NameBasics> nameBasicsList = new ArrayList<>();
        if (dbData == null || dbData.isEmpty()) {
            return nameBasicsList;
        }
        String[] pieces = dbData.split(SEPARATOR);
        for (String id : pieces) {
            NameBasics nm = NameBasics.findById(id);
            nameBasicsList.add(nm);
        }
        return nameBasicsList;
    }
}
