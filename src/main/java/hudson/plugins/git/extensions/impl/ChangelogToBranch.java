package hudson.plugins.git.extensions.impl;

import org.kohsuke.stapler.DataBoundConstructor;

import hudson.Extension;
import hudson.plugins.git.ChangelogOptions;
import hudson.plugins.git.ChangelogToBranchOptions;
import hudson.plugins.git.extensions.GitSCMExtension;
import hudson.plugins.git.extensions.GitSCMExtensionDescriptor;

/**
 * This extension activates the alternative changelog computation,
 * where the changelog is calculated against a specified branch.
 *
 * @deprecated
 * Replaced with ChangelogToRev which allows specifying the changelog against
 * any arbitrary revision rather than only a single branch.
 *
 * @author <a href="mailto:dirk.reske@t-systems.com">Dirk Reske (dirk.reske@t-systems.com)</a>
 */
@Deprecated
public class ChangelogToBranch extends GitSCMExtension {

    private ChangelogToBranchOptions options;

    @DataBoundConstructor
    public ChangelogToBranch(ChangelogToBranchOptions options) {
        if (options == null) {
            throw new IllegalArgumentException("options may not be null");
        }
        this.options = options;
    }

    public ChangelogOptions getOptions() {
        return options;
    }

    @Extension
    public static class DescriptorImpl extends GitSCMExtensionDescriptor {

        @Override
        public String getDisplayName() {
            return "Calculate changelog against a specific branch";
        }
    }
}
