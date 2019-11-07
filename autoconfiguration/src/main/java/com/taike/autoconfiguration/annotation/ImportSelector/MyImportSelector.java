package com.taike.autoconfiguration.annotation.ImportSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    /**
     * 创建 MainImportSelector 实现类，selectImports 返回 Triangle 的全类名。
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.taike.autoconfiguration.annotation.ImportSelector.Triangle"};
    }
}
