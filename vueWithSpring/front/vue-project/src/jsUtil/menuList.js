import axios from 'axios'

export const menu = {
  menuList: [],
  getMenu () {
    const async = async () => {
      try {
        return await axios.get('http://localhost:8050/api/getMenuList.json')
      } catch (error) {
        console.error(error)
      }
    }
    console.log(async)
    async().then(res => {
      console.log(res.data)
      this.menuList = res.data
    })

    return this.menuList
  }
}
