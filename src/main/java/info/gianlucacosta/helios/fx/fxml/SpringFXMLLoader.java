/*§
  ===========================================================================
  Helios - Spring
  ===========================================================================
  Copyright (C) 2013-2015 Gianluca Costa
  ===========================================================================
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  ===========================================================================
*/

package info.gianlucacosta.helios.fx.fxml;

import javafx.fxml.FXMLLoader;
import javafx.util.Callback;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * An FXML loader that instantiates its controllers by retrieving them from the
 * same Spring container into which this class itself was registered
 */
public class SpringFXMLLoader extends FXMLLoader implements ApplicationContextAware {

    private ApplicationContext context;

    public SpringFXMLLoader() {
        setControllerFactory(new Callback<Class<?>, Object>() {
            @Override
            public Object call(Class<?> requestedControllerClass) {
                return context.getBean(requestedControllerClass);
            }

        });
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

}
