package phasfjo.Text;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by paulito on 08.06.2017.
 */
@Configuration
public class TextEditorConfig {

    @Bean
    public TextEditor2 textEditor(){
        return new TextEditor2( spellChecker() );
    }

    @Bean SpellChecker spellChecker(){
        return new SpellChecker();
    }
}
