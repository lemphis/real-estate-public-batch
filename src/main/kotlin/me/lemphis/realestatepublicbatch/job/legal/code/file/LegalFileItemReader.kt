package me.lemphis.realestatepublicbatch.job.legal.code.file

import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.FileSystemResource

@Configuration
class LegalFileItemReader {

    @Bean
    fun legalFlatFileItemReader() = FlatFileItemReaderBuilder<LegalFileSpec>()
        .name("legalFlatFileItemReader")
        .encoding("EUC-KR")
        .targetType(LegalFileSpec::class.java)
        .resource(FileSystemResource("/var/legal/legal_code.txt"))
        .linesToSkip(1)
        .delimited().delimiter("\t").names(
            "법정동코드",
            "법정동명",
            "폐지여부",
        )
        .build()

}
