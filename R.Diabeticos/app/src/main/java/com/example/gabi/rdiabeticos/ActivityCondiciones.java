package com.example.gabi.rdiabeticos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityCondiciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condiciones);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView Texto =(TextView)findViewById(R.id.textView3);

        String TCondiciones = "Política de Privacidad\n " +
                "Última modificación: 25 de marzo de 2016 (ver versiones archivadas) (Los ejemplos de hipervínculos están disponibles al final de este documento)." +
                "Hay muchas maneras diferentes en las que puede utilizar nuestros servicios: para buscar y compartir información, para" +
                "comunicarse con otras personas o para crear contenido nuevo. Cuando usted comparte información con nosotros, por ejemplo" +
                "creando una cuenta de Google, podemos mejorar aún más esos servicios: para mostrarle anuncios y resultados de búsqueda" +
                "más relevantes, ayudarlo a conectarse con la gente o acelerar y facilitar el compartir información con otras personas." +
                "Como usuario de nuestros servicios, queremos que le quede claro cómo utilizamos su información y las maneras en las que" +
                "usted puede proteger su privacidad."+
                "En nuestra Política de Privacidad se explica:\n" +
                "   1) Qué información recopilamos y por qué la recopilamos.\n" +
                "   2) Cómo usamos esa información.\n" +
                "   3) Las opciones que ofrecemos, incluido el modo de acceder y actualizar la información." +
                "Hemos tratado de mantenerlo de la manera más simple posible, pero si no conoce términos como cookies, direcciones de IP," +
                "etiquetas de píxeles y navegadores, primero lea sobre estos términos clave. Su privacidad es importante para Google, de modo" +
                "que aunque sea nuevo en Google o un usuario de largo tiempo, por favor, tómese un momento para conocer nuestras prácticas" +
                "y si tiene alguna pregunta comuníquese con nosotros." +
                "Información que recopilamos\n" +
                "Recopilamos información para brindar mejores servicios a todos nuestros usuarios: desde entender cosas básicas como el" +
                "idioma que usted habla, hasta cosas más complejas como los anuncios que a usted le parecen más útiles, la gente que" +
                "más le importa en línea o los videos de YouTube que le pueden gustar." +
                "Recopilamos información de las siguientes maneras:" +
                "Información que usted nos proporciona.\n Por ejemplo, muchos de nuestros servicios requieren que se registre para" +
                "obtener una cuenta de Google. Cuando lo hace, le solicitamos información personal, como su nombre, dirección de" +
                "correo electrónico, número de teléfono o de tarjeta de crédito para almacenarla junto con su cuenta. Si desea sacar la" +
                "mayor ventaja posible de las funciones de información compartida que ofrecemos, es posible que también le solicitemos" +
                "que cree un Perfil de Google visible en forma pública, que puede incluir su nombre y fotografía." +
                "Información que obtenemos de su uso de nuestros servicios. Recopilamos información sobre los servicios que" +
                "usted utiliza y el modo en que los utiliza, como por ejemplo, cuando mira un video en YouTube, visita un sitio web que" +
                "utiliza nuestros servicios de publicidad o ve e interacciona con nuestros anuncios y contenido.\n Esta información" +
                "incluye:\n" +
                "Información del dispositivo\n" +
                "Recopilamos información específica sobre el dispositivo (como el modelo de hardware, versión del sistema" +
                "operativo, identificadores únicos de dispositivo e información de la red móvil, incluido número de teléfono)." +
                "Google puede asociar sus identificadores de dispositivo o su número de teléfono con su cuenta de Google." +
                "Información de registro\n" +
                "Cuando usa nuestros servicios o ve contenido proporcionado por Google, automáticamente recopilamos y" +
                "almacenamos cierta información en los registros de nuestros servidores.\n Esto incluye:" +
                "detalles sobre el modo en que utilizó nuestro servicio, como sus consultas de búsqueda." +
                "información de registro de telefonía, como su número de teléfono, número del emisor, números de" +
                "desvío de llamadas, fecha y hora de las llamadas, duración de las llamadas, información de" +
                "enrutamiento de SMS y tipos de llamadas." +
                "Dirección de protocolo de Internet.\n" +
                "información de evento del dispositivo, como fallas, actividad del sistema, configuración del hardware, tipo" +
                "de navegador, idioma del navegador, fecha y hora de su solicitud y URL de referencia." +
                "cookies que pueden identificar de manera única a su navegador o a su cuenta de Google." +
                "Información de la ubicación\n" +
                "Si utiliza los servicios de Google, podremos recopilar y procesar información sobre su ubicación real." +
                "Utilizamos diversas tecnologías para determinar la ubicación, incluso la dirección IP, el sistema GPS y otros" +
                "sensores que pueden, por ejemplo, proporcionarle a Google información sobre dispositivos, puntos de acceso" +
                "Wi\u00ADFi y torres de telefonía cercanos.\n" +
                "Números de aplicación únicos\n" +
                "Ciertos servicios incluyen un número de aplicación único. Puede que este número y la información acerca de la" +
                "instalación (por ejemplo, el tipo de sistema operativo y el número de versión de la aplicación) se envíen a" +
                "Google cuando instale o desinstale el servicio, o cuando este establezca conexión con nuestros servidores para," +
                "por ejemplo, obtener actualizaciones automáticas.\n" +
                "Almacenamiento local:\n" +
                "Podremos recopilar y almacenar información (incluida la información personal) en forma local en su dispositivo" +
                "con mecanismos tales como el almacenamiento web del navegador (incluido HTML 5) y memorias caché de" +
                "datos de la aplicación." +
                "Cookies y tecnologías similares\n" +
                "Nosotros y nuestros socios utilizamos diversas tecnologías para recopilar y almacenar información cuando" +
                "visita un servicio de Google, y esto puede incluir el uso de cookies o tecnologías similares para identificar su" +
                "navegador o dispositivo. También utilizamos estas tecnologías para recopilar y almacenar información cuando" +
                "interacciona con servicios que ofrecemos a nuestros socios, como servicios de publicidad o funciones de" +
                "Google que puedan aparecer en otros sitios. Nuestro producto Google Analytics ayuda a empresas y" +
                "propietarios de sitios a analizar el tráfico a sus sitios web y aplicaciones. Cuando se combina con nuestros" +
                "servicios de publicidad, como los que usan la cookie de DoubleClick, el cliente de Google Analytics o Google" +
                "vinculan la información de Google Analytics, mediante la tecnología de Google, con información sobre" +
                "las visitas a varios sitios .\n" +
                "La información que recopilamos cuando accede a Google, además de la que obtenemos sobre usted a través de nuestros" +
                "socios, se puede asociar a su cuenta de Google Cuando está asociada a su cuenta de Google, la tratamos como información" +
                "personal. Para obtener más datos sobre cómo puede acceder, administrar o borrar información que está asociada a su cuenta" +
                "de Google, visite la sección Transparencia y opciones de esta política." +
                "Cómo utilizamos la información que recopilamos\n" +
                "Utilizamos la información que recopilamos de todos nuestros servicios para proveerlos, mantenerlos, protegerlos y" +
                "mejorarlos, para desarrollar otros servicios nuevos y para proteger a Google y a nuestros usuarios. También utilizamos" +
                "esta información para ofrecerle contenido personalizado (por ejemplo, para proporcionarle resultados de la búsqueda y" +
                "anuncios más relevantes).\n" +
                "Podremos utilizar el nombre que usted proporcione para su perfil de Google en todos los servicios que ofrecemos y que" +
                "requieran una cuenta de Google. Además, podremos reemplazar los nombres anteriores relacionados con su cuenta de Google" +
                "de modo que usted sea identificado en forma consistente en todos nuestros servicios. Si otros usuarios ya tienen su dirección" +
                "de correo electrónico u otra información que lo identifique, podremos mostrarles la información visible en forma pública de su" +
                "perfil de Google, como su nombre y su foto.\n" +
                "Si tiene una cuenta de Google, es posible que mostremos su nombre de Perfil, su foto de Perfil y las acciones que realiza en" +
                "Google o en aplicaciones de terceros conectadas a su cuenta de Google (como los +1 que hace, las opiniones que escribe y" +
                "los comentarios que publica) en nuestros servicios, incluida la aparición en anuncios y otros contextos comerciales." +
                "Respetaremos las decisiones que tome en relación con la limitación de la configuración del uso compartido o del nivel de" +
                "visibilidad en la cuenta de Google.\n" +
                "Si usted contacta a Google, conservaremos un registro de su comunicación para ayudar a solucionar cualquier problema que" +
                "pueda tener. Podremos utilizar su dirección de correo electrónico para informarle sobre nuestros servicios, como hacerle saber" +
                "los próximos cambios o mejoras.\n" +
                "Utilizamos la información que proporcionan las cookies y otras tecnologías, como las etiquetas de píxel, para que nuestros" +
                "usuarios disfruten de una mejor experiencia y para mejorar la calidad general de nuestros servicios. Uno de los productos" +
                "que utilizamos para hacerlo en nuestros propios servicios es Google Analytics. Por ejemplo, al guardar sus preferencias de" +
                "idioma, podremos permitir que nuestros servicios aparezcan en el idioma que prefiera. Cuando le mostremos anuncios" +
                "personalizados, no asociaremos un identificador de cookies o tecnologías similares con categorías delicadas, como aquellas" +
                "relacionadas con la raza, la religión, la orientación sexual o la salud.\n" +
                "Nuestros sistemas automatizados analizan el contenido (incluidos los correos electrónicos) para proporcionarle funciones de" +
                "productos que guarden relación con su actividad, como la publicación de anuncios y resultados de búsqueda personalizados y" +
                "la detección de spam y software malicioso.\n" +
                "Puede que combinemos la información personal de un servicio con la de otros servicios de Google, incluida su" +
                "información personal, a fin de, por ejemplo, facilitar el uso compartido de contenido con personas que conoce. No" +
                "combinaremos la información de la cookie de DoubleClick con información de identificación personal, a menos que tengamos" +
                "su consentimiento.\n" +
                "Solicitaremos su consentimiento antes de utilizar la información para otro fin que no sea alguno de los dispuestos en la" +
                "presente Política de Privacidad.\n" +
                "Google procesa la información personal en nuestros servidores en varios países de todo el mundo. Podremos procesar su" +
                "información personal en un servidor ubicado fuera del país en el que usted vive.\n" +
                "Transparencia y opciones\n" +
                "La gente tiene diferentes preocupaciones sobre privacidad. Nuestro objetivo es ser claros en cuanto a la información que" +
                "recopilamos, de modo que usted pueda tomar decisiones significativas sobre cómo se la utiliza. Por ejemplo, usted puede:" +
                "Revise y actualice los controles de actividad de Google para decidir qué tipo de datos (como los videos que miró en" +
                "YouTube o las búsquedas anteriores) le gustaría guardar en la cuenta cuando utiliza los servicios de Google. Además," +
                "puede visitar estos controles para indicar si una determinada actividad se guarda en una cookie o en una tecnología" +
                "similar en su dispositivo cuando usa nuestros servicios sin acceder a su cuenta.\n" +
                "revisar y controlar ciertos tipos de información relacionada con su cuenta de Google mediante el Panel de Google." +
                "Ver y editar las preferencias acerca de los anuncios de Google que le muestran a usted en Google y en toda la Web," +
                "tales como las categorías que le pueden interesar, mediante la Configuración de anuncios. También puede inhabilitar" +
                "ciertos servicios de publicidad de Google aquí." +
                "Ajustar cómo ven los demás el Perfil asociado a su Cuenta de Google." +
                "Controlar con quién comparte información a través de su Cuenta de Google." +
                "Tomar información asociada a su Cuenta de Google de muchos de nuestros servicios." +
                "elegir si el nombre de Perfil y la foto de Perfil aparecerán en las recomendaciones compartidas que se publican en los" +
                "anuncios.\n" +
                "También puede configurar su navegador para bloquear todas las cookies, incluidas las cookies relacionadas con nuestros" +
                "servicios, o para indicar cuándo nosotros configuramos una cookie. Sin embargo, es importante recordar que muchos de" +
                "nuestros servicios podrían no funcionar correctamente si sus cookies están inhabilitadas. Por ejemplo, tal vez no" +
                "recordemos sus preferencias de idioma.\n" +
                "Información que comparte\n" +
                "Muchos de nuestros servicios le permiten compartir información con otras personas. Recuerde que cuando comparte" +
                "información en forma pública, puede ser recopilada por los motores de búsqueda, incluido Google. Nuestros servicios le" +
                "proporcionan diferentes opciones para compartir y eliminar su contenido." +
                "Acceso y actualización de su información personal\n" +
                "Siempre que usted usa nuestros servicios, nos proponemos brindarle acceso a su información personal. Si esa información" +
                "es incorrecta, nos esforzamos por ofrecerle maneras de actualizarla o eliminarla rápidamente (a menos que debamos" +
                "conservar esa información por motivos comerciales o legales legítimos). Si actualiza su información personal, tal vez le" +
                "pidamos que verifique su identidad antes de que podamos actuar según su solicitud.\n" +
                "Es posible que rechacemos las solicitudes que son irrazonablemente repetitivas, requieren un esfuerzo técnico" +
                "desproporcionado (por ejemplo, desarrollar un sistema nuevo o cambiar una práctica actual radicalmente), ponen en riesgo la" +
                "privacidad de otros o resultan muy poco prácticas (por ejemplo, aquellas solicitudes relacionadas con la información" +
                "almacenada en sistemas de copia de seguridad).\n" +
                "Cuando podamos proporcionar el acceso y la corrección de la información, lo haremos de forma gratuita, a menos que se" +
                "requiera un esfuerzo desproporcionado. Nos proponemos mantener nuestros servicios de manera tal que se proteja la" +
                "información de una destrucción accidental o maliciosa. Debido a ésto, luego de que usted elimine información de nuestros" +
                "servicios, podríamos no eliminar inmediatamente las copias residuales de nuestros servidores activos, ni las copias de" +
                "seguridad de nuestros sistemas.\n" +
                "Información que compartimos\n" +
                "No compartimos información personal con empresas, organizaciones o personas que no forman parte de Google, a menos que" +
                "se produzca alguna de las siguientes circunstancias:\n" +
                "Con su consentimiento" +
                "Compartiremos información personal con empresas, organizaciones o individuos fuera de Google si tenemos su" +
                "consentimiento para hacerlo. Solicitamos que preste su consentimiento para compartir cualquier tipo de información" +
                "personal confidencial.\n" +
                "Con administradores de dominio\n" +
                "Si un administrador de dominio administra su cuenta de Google (por ejemplo, para usuarios de Google Apps), entonces" +
                "su administrador de dominio y los revendedores que brinden soporte al usuario en su organización, tendrán acceso a la" +
                "información de su cuenta de Google (incluida su dirección de correo electrónico y otros datos). Su administrador de" +
                "dominio podrá:\n" +
                "ver estadísticas sobre su cuenta, como las estadísticas relacionadas con las aplicaciones que instale." +
                "cambiar la contraseña de su cuenta." +
                "suspender o finalizar el acceso a su cuenta." +
                "conservar o acceder a la información almacenada como parte de su cuenta." +
                "recibir la información de su cuenta a fin de cumplir con leyes aplicables, regulaciones, procesos legales o" +
                "requerimientos gubernamentales exigibles." +
                "restringir su capacidad de eliminar o editar la información o la configuración de privacidad." +
                "Por favor, consulte la política de privacidad de su administrador de dominio para obtener más información." +
                "Para procesamiento externo\n" +
                "Proporcionamos información personal a nuestros afiliados u otras empresas o personas de confianza para que la" +
                "procesen por nosotros, según nuestras instrucciones y conforme a nuestra Política de Privacidad y a cualquier otra" +
                "medida pertinente de confidencialidad y seguridad.\n" +
                "Por motivos legales" +
                "Compartiremos información personal con empresas, organizaciones e individuos fuera de Google si creemos de buena" +
                "fe que el acceso, el uso, la conservación o la divulgación de la información es razonablemente necesaria para:" +
                "cumplir con las leyes aplicables, las regulaciones, los procesos legales o las exigencias gubernamentales" +
                "vigentes.\n" +
                "garantizar el cumplimiento de las Condiciones del servicio correspondientes, incluida la investigación de" +
                "posibles violaciones." +
                "detectar, evitar o de otro modo tratar los problemas técnicos, de fraude o seguridad." +
                "proteger de posibles daños a los derechos, la propiedad o la seguridad de Google, de nuestros usuarios o del" +
                "público según lo establezca o permita la ley.\n" +
                "Es posible que compartamos información que no permita identificarlo de manera personal en forma pública y con nuestros" +
                "socios, como editores, anunciantes o sitios conectados. Por ejemplo, podremos compartir información en forma pública para" +
                "mostrar las tendencias sobre el uso general de nuestros servicios." +
                "Si Google se involucra en una fusión, adquisición o venta de activos, continuaremos asegurando la confidencialidad de" +
                "cualquier información personal y notificaremos a los usuarios afectados antes de que la información personal se transfiera o" +
                "esté sujeta a una política de privacidad diferente.\n" +
                "Seguridad de la información\n" +
                "Nos esforzamos en proteger a Google y nuestros usuarios del acceso no autorizado o cualquier modificación, divulgación o" +
                "destrucción no autorizada de la información que poseemos. En particular:" +
                "Encriptamos muchos de nuestros servicios usando SSL." +
                "Le ofrecemos a usted la verificación en dos pasos cuando accede a su cuenta de Google y una función de navegación" +
                "segura en Google Chrome." +
                "Revisamos nuestras prácticas de recopilación, almacenamiento y procesamiento de información, incluidas nuestras" +
                "medidas de seguridad física, para protegernos frente al acceso no autorizado a los sistemas." +
                "Restringimos el acceso a la información personal a los empleados, contratistas y agentes de Google que necesiten" +
                "conocer tal información para procesarla por nosotros, y que estén sujetos a estrictas obligaciones contractuales de" +
                "confidencialidad y puedan ser sancionados o despedidos si no cumplen con estas obligaciones." +
                "Situaciones en las que se aplica esta Política de Privacidad" +
                "Nuestra Política de privacidad se aplica a todos los servicios ofrecidos por Google Inc. y sus afiliados, incluido YouTube, los" +
                "servicios que Google brinda en los dispositivos Android y los servicios ofrecidos en otros sitios (como nuestros servicios de" +
                "publicidad), pero excluye los servicios que tienen políticas de privacidad separadas que no incorporan la presente Política de" +
                "privacidad.\n" +
                "Nuestra Política de Privacidad no se aplica a los servicios ofrecidos por otras empresas o individuos, incluidos los productos o" +
                "sitios que puedan aparecer como resultados de búsqueda, los sitios que puedan incluir servicios de Google u otros sitios" +
                "vinculados desde nuestros servicios. Nuestra Política de Privacidad no cubre las prácticas de información de otras empresas y" +
                "organizaciones que anuncian nuestros servicios y que puedan utilizar cookies, etiquetas de píxeles y otras tecnologías para" +
                "proveer y ofrecer anuncios relevantes.\n" +
                "Conformidad y colaboración con las autoridades normativas" +
                "Revisamos periódicamente el cumplimiento de nuestra Política de Privacidad. También nos adherimos a varios marcos auto" +
                "regulatorios. Cuando recibimos reclamos formales por escrito, nos contactaremos con la persona que realizó el reclamo para" +
                "hacer un seguimiento. Trabajamos con las autoridades reguladoras correspondientes, incluidas las autoridades locales de" +
                "protección de datos, a fin de resolver cualquier reclamo relacionado con la transferencia de datos personales que no podemos" +
                "resolver directamente con nuestros usuarios.\n" +
                "Modificaciones\n" +
                "Nuestra Política de Privacidad puede modificarse ocasionalmente. No limitaremos sus derechos derivados de la presente" +
                "Política de Privacidad sin su expreso consentimiento. Publicaremos cualquier modificación de la presente Política de Privacidad" +
                "en esta página y, si estas modificaciones son significativas, le enviaremos una notificación más destacada (por ejemplo, una" +
                "notificación por correo electrónico sobre las modificaciones de la política de privacidad, en el caso de determinados servicios)." +
                "Además, conservaremos las versiones anteriores de la presente Política de Privacidad en un archivo para que pueda" +
                "consultarlas.\n" +
                "Prácticas específicas de productos\n" +
                "Las siguientes notificaciones explican las prácticas específicas de privacidad con respecto a ciertos productos y servicios de" +
                "Google que usted puede utilizar:\n" +
                "Chrome y Sistema operativo de Chrome\n" +
                "       Play Libros\n" +
                "       Payments\n" +
                "       Fiber\n" +
                "       Project Fi\n" +
                "       Google Apps for Education\n" +
                "Para obtener más información sobre algunos de nuestros servicios más populares, puede visitar la Guía de privacidad de los" +
                "productos de Google.\n" +
                "Otros materiales útiles relacionados con la seguridad y la privacidad" +
                "Las páginas con las políticas y los principios de Google ofrecen más materiales relacionados con la privacidad y la seguridad," +
                "como:\n" +
                "información acerca de nuestras tecnologías y nuestros principios, que incluye datos sobre:" +
                "cómo Google usa las cookies;" +
                "las tecnologías que usamos para la publicidad;" +
                "cómo reconocemos patrones como los rostros;" +
                "una página que explica qué información se comparte con Google cuando visita sitios web que usan nuestros productos" +
                "publicitarios, sociales y de análisis;" +
                "la herramienta de Control de privacidad, que facilita la revisión de la configuración de privacidad clave." +
                "el centro de seguridad de Google, que proporciona datos acerca de cómo puede permanecer seguro y protegido en" +
                "línea." +
                "acceso a su información personal" +
                "Por ejemplo, con el Panel de control de Google puede ver algunos de los datos asociados a su cuenta de Google de manera" +
                "fácil y rápida." +
                "Más información" +
                "anuncios más útiles para usted" +
                "Por ejemplo, si visita frecuentemente sitios web y blogs de jardinería, puede ver anuncios relacionados con la jardinería al" +
                "navegar en Internet." +
                "Más información\n" +
                "servicios publicitarios" +
                "Por ejemplo, si visita frecuentemente sitios web y blogs de jardinería en los que aparecen nuestros anuncios, puede empezar a" +
                "ver anuncios relacionados con ese tema al navegar en Internet." +
                "Más información" +
                "y otros sensores" +
                "El dispositivo podría tener sensores que proporcionen información para ayudar a determinar su posición. Por ejemplo, se" +
                "puede usar un acelerómetro para determinar magnitudes como la velocidad o un giróscopo para conocer la dirección de" +
                "movimiento.\n" +
                "Más información\n" +
                "recopilar información" +
                "La información recopilada incluye sus preferencias y datos de uso, mensajes de Gmail, información del perfil de Google+, fotos," +
                "videos, datos del historial de navegación, búsquedas de mapas, documentos u otro contenido alojado en Google." +
                "Más información\n" +
                "combinar la información personal de un servicio con información de otros servicios de Google (incluidos los datos" +
                "personales)" +
                "Por ejemplo, si accede a su cuenta de Google y hace una búsqueda en Google, puede ver resultados de búsqueda de la Web" +
                "pública, junto con páginas, fotos y publicaciones de Google+ de sus amigos; y las personas que lo conocen o lo siguen en" +
                "Google+ pueden ver sus publicaciones y su perfil en sus resultados.\n" +
                "Más información\n" +
                "conectarse con otras personas" +
                "Por ejemplo, puede recibir sugerencias de personas que podría conocer o con las que podría querer conectarse en Google+ en" +
                "función de las conexiones que haya establecido con otras personas en otros productos de Google, como Gmail. Asimismo, las" +
                "personas que tengan alguna conexión con usted podrán ver su perfil como sugerencia." +
                "Más información\n" +
                "tarjeta de crédito" +
                "Actualmente no solicitamos tarjetas de crédito durante el proceso de registro. Sin embargo, una pequeña transacción con una" +
                "tarjeta de crédito puede ser una manera de confirmar que el usuario cumple los requisitos de edad en caso de que su cuenta" +
                "se inhabilite tras haber ingresado una fecha de nacimiento que indique que no tiene la edad necesaria para tener una cuenta" +
                "de Google.\n" +
                "Más información\n" +
                "desarrollar nuevas funciones" +
                "Por ejemplo, el software de revisión ortográfica de Google se desarrolló al analizar búsquedas anteriores en las que los" +
                "usuarios habían corregido su propia ortografía." +
                "Más información\n" +
                "identificadores de dispositivos" +
                "Los identificadores de dispositivos permiten que Google sepa qué dispositivo único utiliza cada usuario para acceder a" +
                "nuestros servicios. Esta información se puede utilizar para personalizar el servicio para cada dispositivo o para analizar" +
                "problemas de los dispositivos relacionados con nuestros servicios." +
                "Más información\n" +
                "información específica del dispositivo" +
                "Por ejemplo, cuando accede a Google Play desde su computadora, Google puede utilizar esa información para ayudarlo a" +
                "decidir en qué dispositivos le gustaría poder utilizar sus compras." +
                "Más información" +
                "mejorar la experiencia del usuario" +
                "Por ejemplo, las cookies nos permiten analizar cómo interaccionan los usuarios con nuestros servicios." +
                "Más información" +
                "proceso legal o exigencia gubernamental" +
                "Al igual que otras empresas de tecnología y comunicaciones, Google recibe regularmente solicitudes de información sobre los" +
                "usuarios procedentes de organismos judiciales y gubernamentales de todo el mundo." +
                "Más información\n" +
                "limitación de la configuración del uso compartido o del nivel de visibilidad" +
                "Por ejemplo, puede configurar su cuenta de manera que su nombre y su foto no aparezcan en un anuncio." +
                "Más información\n" +
                "vinculado con información acerca de las visitas a varios sitios" +
                "Google Analytics se basa en las cookies de origen. Los datos generados a través de Google Analytics pueden vincularse, por" +
                "parte del cliente de Google Analytics o Google, mediante el uso de la tecnología de Google, a cookies de terceros," +
                "relacionados con visitas a otros sitios web, por ejemplo, cuando un anunciante quiere usar sus datos de Google Analytics para" +
                "crear más anuncios relevantes, o para analizar aún más su tráfico." +
                "Más información" +
                "mantener" +
                "Por ejemplo, monitoreamos nuestros sistemas de forma continua para comprobar que funcionen como está previsto y para" +
                "detectar y corregir errores." +
                "Más información\n" +
                "podemos recopilar y procesar información sobre su ubicación actual" +
                "Por ejemplo, Google Maps puede centrar las vistas de mapa en su ubicación actual." +
                "Más información" +
                "posibles problemas de funcionamiento" +
                "Por ejemplo, utilizamos una cookie denominada \"lbcs\" que hace posible que Documentos de Google pueda abrir muchos" +
                "documentos en un navegador." +
                "Más información\n" +
                "y nuestros socios" +
                "Permitimos que las empresas confiables utilicen cookies o tecnologías similares para fines publicitarios o de investigación en" +
                "nuestros servicios." +
                "Más información\n" +
                "número de teléfono" +
                "Por ejemplo, si agrega un número de teléfono como opción de recuperación y olvida su contraseña, Google puede enviarle un" +
                "mensaje de texto con un código para que pueda restablecerla." +
                "Más información\n" +
                "protección de Google y de nuestros usuarios" +
                "Por ejemplo, si le preocupa que puedan acceder sin autorización a su correo electrónico, puede ver información sobre la" +
                "actividad reciente de su correo de Gmail en \"Última actividad de la cuenta\" (por ejemplo, direcciones IP desde las que se" +
                "accedió a su correo, ubicación asociada, fecha y hora).\n" +
                "Más información\n" +
                "proteger" +
                "Por ejemplo, una de las razones por las que recopilamos y analizamos las direcciones IP y las cookies es para proteger" +
                "nuestros servicios de abusos automatizados." +
                "Más información\n" +
                "proveer" +
                "Por ejemplo, la dirección IP asignada a su dispositivo se utiliza para enviar los datos que usted solicitó de vuelta a su" +
                "dispositivo." +
                "Más información\n" +
                "compartir" +
                "Por ejemplo, con Google+, usted tiene muchas opciones distintas para compartir contenido." +
                "Más información\n" +
                "compartir contenido con otros usuarios de manera más fácil y rápida" +
                "Por ejemplo, si una persona ya se encuentra entre sus contactos, Google completará automáticamente su nombre si quiere" +
                "agregarla a un mensaje en Gmail.\n" +
                "Más información\n" +
                "las personas que más le interesan en línea" +
                "Por ejemplo, al escribir una dirección en el campo Para, Cc o Cco de un mensaje que está redactando, Gmail le sugiere" +
                "direcciones de su lista de contactos.\n" +
                "Más información\n" +
                "poder compartir contenido más fácilmente con las personas que conoce" +
                "Por ejemplo, si se ha comunicado con alguien a través de Gmail y quiere agregar a esa persona a un documento de Google o" +
                "a un evento en el Calendario de Google, Google le facilita la tarea al completar automáticamente la dirección de correo" +
                "electrónico de esa persona cuando empieza a escribir su nombre.\n" +
                "Más información\n" +
                "visualización de nuestros anuncios e interacción con ellos" +
                "Por ejemplo, informamos regularmente a cada anunciante si mostramos su anuncio en una página y las probabilidades de que" +
                "los usuarios lo hayan visto (en comparación, por ejemplo, con las probabilidades que existirían si el anuncio apareciera en una" +
                "parte de la página a la que no se hayan desplazado los usuarios).\n" +
                "Más información\n" +
                "Podemos compartir públicamente información global que no permita la identificación personal" +
                "Cuando muchas personas empiezan a buscar algo, ese hecho puede proporcionar información de gran utilidad acerca de" +
                "tendencias específicas en ese momento.\n" +
                "Más información\n" +
                "Puntos de acceso de Wi\u00ADFi y torres de telefonía" +
                "Por ejemplo, Google puede hacer un cálculo aproximado de la ubicación del dispositivo sobre la base de la ubicación conocida" +
                "de las torres de telefonía cercanas.\n" +
                "Más información\n" +
                "resultados de la búsqueda más relevantes" +
                "Por ejemplo, podemos ofrecerle resultados de búsqueda más interesantes y relevantes, como fotos, publicaciones y más" +
                "contenidos suyos y de sus amigos.\n" +
                "Más información\n" +
                "eliminación del contenido" +
                "Por ejemplo, puede borrar su Actividad web y en aplicaciones, su blog, un sitio de Google propio, su canal de YouTube, su" +
                "perfil de Google+ o toda su cuenta de Google.\n" +
                "Más información\n" +
                "para mostrar las tendencias" +
                "Puede consultar algunas de estas tendencias en Tendencias de búsqueda de Google y Tendencias de búsqueda de YouTube.\n" ;

        Texto.setText(TCondiciones);

        Button BtnAceptar = (Button)findViewById(R.id.BtnAceptar);
        BtnAceptar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ActivityLogin.class);
                startActivity(i);
            }
        });
        Button BtnCancelar = (Button)findViewById(R.id.BtnCancelar);
        BtnCancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Debes Aceptar las Condiciones para Acceder ", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
