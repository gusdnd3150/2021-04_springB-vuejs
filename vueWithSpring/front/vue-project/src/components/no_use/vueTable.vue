<template>
  <div>
    <vuetable
      ref="vuetable"
      api-url="https://vuetable.ratiw.net/api/users"
      :fields="fields"
      :sort-order="sortOrder"
      data-path="data"
      :per-page="5"
      :css="css.table"
      pagination-path=""
      @vuetable:pagination-data="onPaginationData"
      @vuetable:row-clicked="onclickEvent"
      >

      <template slot-scope="props">
        <span v-if="props.rowData.gender === 'M'" class="ui teal label"><i class="large man icon"></i>Male</span>
        <span v-else class="ui pink label"><i class="large woman icon"></i>Female</span>
      </template>

    </vuetable>

    <div class="pagination ui basic segment grid">

      <vuetable-pagination-info ref="paginationInfo">
      </vuetable-pagination-info>

      <vuetable-pagination ref="pagination"
      :css="css.pagination"  @vuetable-pagination:change-page="onChangePage">
        </vuetable-pagination>

    </div>
  </div>
</template>

<script>
import Vuetable from 'vuetable-2'
import VuetablePagination from 'vuetable-2/src/components/VuetablePagination'
import VuetablePaginationInfo from 'vuetable-2/src/components/VuetablePaginationInfo'

export default {
  name: 'vueTable',
  data: function () {
    return {
      fields: [
        {
          name: 'name',
          title: '<i class="grey user outline icon"></i>Name',
          width: '20%',
          sortField: 'name'
        },
        {
          name: 'email',
          title: '<i class="grey mail outline icon"></i>Email',
          width: '20%',
          sortField: 'email'
        },
        {
          name: 'birthdate',
          title: '<i class="grey birthday icon"></i>Birthdate',
          width: '15%',
          formatter: (value) => {
            return value === null ? '' : '0000-12-31'
          }
        },
        {
          name: '__slot:gender',
          title: '<i class="grey heterosexual icon"></i>Gender',
          titleClass: 'center aligned',
          dataClass: 'center aligned',
          width: '15%'
        },
        {
          name: 'salary',
          title: '<i class="grey money icon"></i>Salary',
          titleClass: 'center aligned',
          dataClass: 'right aligned',
          width: '15%',
          formatter: (value) => value,
          sortField: 'salary'
        }
      ],
      sortOrder: [
        {
          field: 'email',
          direction: 'asc'
        }
      ],
      css: {
        table: {
          tableClass: 'table table-bordered table-striped table-hover',
          loadingClass: 'loading',
          ascendingIcon: 'glyphicon glyphicon-chevron-up',
          descendingIcon: 'blue chevron down icon',
          handleIcon: 'glyphicon glyphicon-menu-hamburger'
        },
        pagination: {
          wrapperClass: 'pagination',
          activeClass: 'active',
          disabledClass: 'disabled',
          pageClass: 'pagination page-item',
          linkClass: 'page-item',
          paginationClass: 'pagination',
          paginationInfoClass: 'float-left',
          dropdownClass: 'form-control',
          icons: {
            first: 'fa fa-chevron-left',
            prev: 'fa fa-chevron-left',
            next: 'fa fa-chevron-right',
            last: 'btn btn-dark'
          }
        }
      }
    }
  },
  components: {
    Vuetable,
    VuetablePagination,
    VuetablePaginationInfo
  },
  methods: {
    onPaginationData (paginationData) {
      this.$refs.pagination.setPaginationData(paginationData)
      this.$refs.paginationInfo.setPaginationData(paginationData)
    },
    onChangePage (page) {
      this.$refs.vuetable.changePage(page)
    },
    onclickEvent (data) {
      alert(data)
      console.log(data)
    }
  }
}

</script>
