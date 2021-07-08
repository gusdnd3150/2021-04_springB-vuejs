<template>
    <div class="editor">
        <editor-menu-bar  :editor="editor" v-slot="{ commands, isActive, getMarkAttrs }">
            <div class="menubar">
                <button class="menubar__button" @click.prevent="showLinkMenu(getMarkAttrs('link'))" :class="{ 'is-active': isActive.link() }">
                    <f-icon :icon="['fas', 'link']" />
                </button>
<button class="menubar__button" :class="{ 'is-active': isActive.bold() }" @click.prevent="commands.bold">
                    <f-icon :icon="['fas', 'bold']" />
                </button>
<button class="menubar__button" :class="{ 'is-active': isActive.italic() }" @click.prevent="commands.italic">
                    <f-icon :icon="['fas', 'italic']" />
                </button>
<button class="menubar__button" :class="{ 'is-active': isActive.strike() }" @click.prevent="commands.strike">
                    <f-icon :icon="['fas','link']" />
                </button>
<button class="menubar__button" :class="{ 'is-active': isActive.underline() }" @click.prevent="commands.underline">
                    <f-icon :icon="['fas', 'underline']" />
                </button>
<button class="menubar__button" :class="{ 'is-active': isActive.code() }" @click.prevent="commands.code">
                    <f-icon :icon="['fas', 'code']" />
                </button>
<button class="menubar__button" :class="{ 'is-active': isActive.code_block() }" @click.prevent="commands.code_block">
                    <f-icon :icon="['fas', 'file-code']" />
                </button>
<button class="menubar__button" :class="{ 'is-active': isActive.paragraph() }" @click.prevent="commands.paragraph">
                    <f-icon :icon="['fas', 'paragraph']" />
                </button>
<button class="menubar__button" :class="{ 'is-active': isActive.heading({ level: 1 }) }" @click.prevent="commands.heading({ level: 1 })">
                    H1
                </button>
<button class="menubar__button" :class="{ 'is-active': isActive.heading({ level: 2 }) }" @click.prevent="commands.heading({ level: 2 })">
                    H2
                </button>
<button class="menubar__button" :class="{ 'is-active': isActive.heading({ level: 3 }) }" @click.prevent="commands.heading({ level: 3 })">
                    H3
                </button>
<button class="menubar__button" :class="{ 'is-active': isActive.bullet_list() }" @click.prevent="commands.bullet_list">
                    <f-icon :icon="['fas', 'list-ul']" />
                </button>
<button class="menubar__button" :class="{ 'is-active': isActive.ordered_list() }" @click.prevent="commands.ordered_list">
                    <f-icon :icon="['fas', 'list-ol']" />
                </button>
<button class="menubar__button" :class="{ 'is-active': isActive.blockquote() }" @click.prevent="commands.blockquote">
                    <f-icon :icon="['fas', 'quote-left']" />
                </button>
<button class="menubar__button" @click.prevent="commands.horizontal_rule">
                    <f-icon :icon="['fas', 'window-minimize']" />
                </button>
<button class="menubar__button" @click.prevent="commands.undo">
                    <f-icon :icon="['fas', 'undo']" />
                </button>
<button class="menubar__button" @click.prevent="commands.redo">
                    <f-icon :icon="['fas', 'redo']" />
                </button>
            </div>
        </editor-menu-bar>
         <editor-content class="editor__content" :editor="editor" />

    </div>
</template>
<script>
import { Editor, EditorContent, EditorMenuBar } from 'tiptap'
import { Blockquote, CodeBlock, HardBreak, Heading, HorizontalRule, OrderedList, BulletList, ListItem, TodoItem, TodoList, Bold, Code, Italic, Link, Strike, Underline, History } from 'tiptap-extensions'

export default {
  components: {
    EditorContent,
    EditorMenuBar
  },
  props: ['description', 'menubar', 'readOnly'],
  data () {
    return {
      swMenubar: this.menubar,
      linkUrl: null,
      linkMenuIsActive: false,
      editor: null
    }
  },
  mounted () {
    this.editor = new Editor({
      editable: !this.readOnly,
      extensions: [new Blockquote(), new BulletList(), new CodeBlock(), new HardBreak(), new Heading({ levels: [1, 2, 3] }), new Link({ rel: '', target: '_blank' }), new HorizontalRule(), new ListItem(), new OrderedList(), new TodoItem(), new TodoList(), new Bold(), new Code(), new Italic(), new Strike(), new Underline(), new History()],
      content: this.description,
      onUpdate: ({ getHTML }) => {
        this.$emit('editorContent', getHTML())
      }
    })
  },
  beforeDestroy () {
    this.editor.destroy()
  },
  methods: {
    showLinkMenu (attrs) {
      this.linkUrl = attrs.href
      this.linkMenuIsActive = true
      this.$nextTick(() => {
        this.$refs.linkInput.focus()
      })
    },
    hideLinkMenu () {
      this.linkUrl = null
      this.linkMenuIsActive = false
    },
    setLinkUrl (command, url) {
      command({ href: url, target: '_blank' })
      this.hideLinkMenu()
    }
  }
}
</script>
<style scoped>
.editor {
    position: relative;
    border-style: solid;
    border-radius: 5px;
    border-width: 1px;
    width: 400px;
    height: 400px;
}

</style>
