import Vue from 'vue'
import { library } from '@fortawesome/fontawesome-svg-core'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faSearch, faSignOutAlt, faSignInAlt, faLink, faBold, faUnderline, faItalic, faCode, faFileCode, faParagraph, faListUl, faListOl, faQuoteLeft, faWindowMinimize, faUndo, faRedo } from '@fortawesome/free-solid-svg-icons'

/* 필요한 아이콘 만큼 각각 추가해주어야 컴포넌트로 불러올 때에 읽어들일 수 있다. */
library.add(faSearch, faSignOutAlt, faSignInAlt, faLink, faBold, faUnderline, faItalic, faCode, faFileCode, faParagraph, faListOl, faListUl, faQuoteLeft, faWindowMinimize, faUndo, faRedo)

/* 뷰 컴포넌트로 사용하겠다는 설정 */
Vue.component('f-icon', FontAwesomeIcon)
