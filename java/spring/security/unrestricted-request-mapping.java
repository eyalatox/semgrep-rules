// cf. https://find-sec-bugs.github.io/bugs.htm#SPRING_CSRF_UNRESTRICTED_REQUEST_MAPPING

@Controller
public class Controller {

    @RequestMapping("/path")
    public void writeData() {
        // State-changing operations performed within this method.
    }

    @RequestMapping(value = "/path")
    public void writeData2() {
        // State-changing operations performed within this method.
    }
    
    /**
     * For methods without side-effects use either
     * RequestMethod.GET, RequestMethod.HEAD, RequestMethod.TRACE, or RequestMethod.OPTIONS.
     */
    @RequestMapping(value = "/path", method = RequestMethod.GET)
    public String readData() {
        // No state-changing operations performed within this method.
        return "";
    }

    /**
     * For state-changing methods use either
     * RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, or RequestMethod.PATCH.
     */
    @RequestMapping(value = "/path", method = RequestMethod.POST)
    public void writeData3() {
        // State-changing operations performed within this method.
    }
}